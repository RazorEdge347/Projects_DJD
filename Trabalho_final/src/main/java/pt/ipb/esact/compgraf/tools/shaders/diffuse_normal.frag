varying vec3 lightVec;
varying vec3 eyeVec;
varying vec2 texCoord;
uniform sampler2D diffuse_map;
uniform sampler2D normal_map;
uniform float alpha_bump;
uniform float beta_bump;

void main (void)
{

	float distSqr = dot(lightVec, lightVec);
	float att = 1.0; // clamp(1.0 - invRadius * sqrt(distSqr), 0.0, 1.0);

	vec3 lVec = lightVec * inversesqrt(distSqr);
	vec3 vVec = normalize(eyeVec);

	vec4 base = texture2D(diffuse_map, texCoord);
	vec3 bump = normalize(texture2D(normal_map, texCoord).xyz * beta_bump - alpha_bump);

	vec4 vAmbient = gl_LightSource[0].ambient * gl_FrontMaterial.ambient;

	float diffuse = max(dot(lVec, bump), 0.0);
	vec4 vDiffuse = gl_LightSource[0].diffuse * gl_FrontMaterial.diffuse * diffuse;

	float specular = pow(clamp(dot(reflect(-lVec, bump), vVec), 0.0, 1.0), gl_FrontMaterial.shininess);
	vec4 vSpecular = gl_LightSource[0].specular * gl_FrontMaterial.specular * specular;

	gl_FragColor = (vAmbient * base + vDiffuse * base + vSpecular) * att;
}
