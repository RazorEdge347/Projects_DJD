//movement
if keyboard_check(vk_up)
   {
   vspeed = -PLspeed;
   }else if keyboard_check(vk_down)
   {
   vspeed = PLspeed;
   }else{
   vspeed = 0;
}
   
 if keyboard_check(vk_left)
   {
   hspeed = -PLspeed;
   }else if keyboard_check(vk_right)
   {
   hspeed = PLspeed;
   }else{
   hspeed = 0;
}
// sprite change
if hspeed = 0 && vspeed < 0{
    sprite_index = s_PL_Up;
    
    if keyboard_lastkey = vk_up && keyboard_check(vk_left){
    sprite_index = s_PL_Up;
    }else if keyboard_lastkey = vk_up && keyboard_check(vk_right){
    sprite_index = s_PL_Up;  
    }
    
    }else if hspeed = 0 && vspeed > 0{
    sprite_index = s_PL_Down;
    
    if keyboard_lastkey = vk_down && keyboard_check(vk_left){
    sprite_index = s_PL_Down;
    }else if keyboard_lastkey = vk_down && keyboard_check(vk_right){
    sprite_index = s_PL_Down;  
    }  
}

if vspeed = 0 && hspeed < 0{
    sprite_index = s_PL_Left;
    
    if keyboard_lastkey = vk_left && keyboard_check(vk_up){
    sprite_index = s_PL_Left;
    }else if keyboard_lastkey = vk_left && keyboard_check(vk_down){
    sprite_index = s_PL_Left;  
    }
    
    }else if vspeed = 0 && hspeed > 0{
    sprite_index = s_PL_Right;  
    
    if keyboard_lastkey = vk_right && keyboard_check(vk_up){
    sprite_index = s_PL_Right;
    }else if keyboard_lastkey = vk_right && keyboard_check(vk_down){
    sprite_index = s_PL_Right;  
    }
}
