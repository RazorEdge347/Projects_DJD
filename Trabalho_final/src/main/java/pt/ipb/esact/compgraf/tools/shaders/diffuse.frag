varying vec3 normal, eyeVec;
uniform sampler2D diffuse_map;

void main (void)
{
	vec4 color = vec4(0.0, 0.0, 0.0, 1.0);

	const int MAX_LIGHTS = 4;

	vec3 N = normalize(normal);

	 vec4 base = texture2D(diffuse_map, gl_TexCoord[0].st);

	for(int i=0; i<MAX_LIGHTS; i++) {
		vec3 spotDir = gl_LightSource[i].spotDirection.xyz;
		vec3 lightDir = vec3(gl_LightSource[i].position.xyz + eyeVec);
		float falloff_percent = gl_LightSource[i].spotExponent / gl_LightSource[i].spotCutoff;

		float d = length(lightDir);

		float att = 1.0 / ( gl_LightSource[i].constantAttenuation +
			(gl_LightSource[i].linearAttenuation * d) +
			(gl_LightSource[i].quadraticAttenuation * d * d) );

		vec4 final_color =
			(gl_FrontLightModelProduct.sceneColor * gl_FrontMaterial.ambient) +
			(gl_LightSource[i].ambient * gl_FrontMaterial.ambient) * att * base;

		vec3 L = normalize(lightDir);
		vec3 D = normalize(spotDir);
		float spotSinCutoff = sin(radians(gl_LightSource[i].spotCutoff));

		// Falloff Stuff
		float sin_cur_angle = sqrt(1.0 - pow(dot(-L, D), 2.0));
		float sin_falloff = spotSinCutoff * (1.0 - falloff_percent);

		float lambertTerm = dot(N, L);
		// If this is a spot light

		if(lambertTerm > 0.0) {
			vec3 E = normalize(eyeVec);
			vec3 R = reflect(-L, N);

			float specular = pow(max(dot(R, E), 0.0), gl_FrontMaterial.shininess);

			if(sin_cur_angle < spotSinCutoff) {
				float falloff = 1.0;
	
				if(sin_cur_angle > sin_falloff)
					falloff = (sin_cur_angle - spotSinCutoff) / (sin_falloff - spotSinCutoff);
	
				final_color +=
					gl_LightSource[i].diffuse *
					gl_FrontMaterial.diffuse *
					lambertTerm * att * falloff * base;
	
				final_color +=
					gl_LightSource[i].specular *
					gl_FrontMaterial.specular * specular * att * falloff;

			} else if(gl_LightSource[i].spotCutoff > 90.0) { // not a spot
				final_color +=
					gl_LightSource[i].diffuse *
					gl_FrontMaterial.diffuse
					* att * lambertTerm * base;
					
				final_color +=
					gl_LightSource[i].specular *
					gl_FrontMaterial.specular
					* specular * att;
			}
		}
		
		color += final_color;
	}

	gl_FragColor = color;
	gl_FragColor.a = gl_FrontMaterial.diffuse.a;
}
