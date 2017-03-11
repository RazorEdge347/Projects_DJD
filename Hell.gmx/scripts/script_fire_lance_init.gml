global.pt_fire=part_type_create();
global.pt_emitter=part_emitter_create(global.ps);
var pt = global.pt_fire;

part_type_shape(pt, pt_shape_flare);
part_type_size(pt,.001,.002,-2,1);
part_type_color2(pt,c_aqua, c_aqua);
part_type_speed(pt,0,0.5,-1,0);
part_type_direction(pt,0,360,1,0);
part_type_life(pt,5,10); 

