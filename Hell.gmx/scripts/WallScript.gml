//down
    if keyboard_check(vk_right) && keyboard_lastkey = vk_down{
        vspeed = 0;
        hspeed = PLspeed;
    }
    if keyboard_check(vk_left) && keyboard_lastkey = vk_down{
        vspeed = 0;
        hspeed = -PLspeed;
    }
//up
    if keyboard_check(vk_left) && keyboard_lastkey = vk_up{
        vspeed = 0;
        hspeed = -PLspeed;
    }
    if keyboard_check(vk_right) && keyboard_lastkey = vk_up{
        vspeed = 0;
        hspeed = PLspeed;
    }
//left
    if keyboard_check(vk_up) && keyboard_lastkey = vk_left{
        vspeed = -PLspeed;
        hspeed = 0;
    }

    if keyboard_check(vk_down) && keyboard_lastkey = vk_left{
        vspeed = PLspeed;
        hspeed = 0;
    }
//right
    if keyboard_check(vk_up) && keyboard_lastkey = vk_right{
        vspeed = -PLspeed;
        hspeed = 0;
    }
    
    if keyboard_check(vk_down) && keyboard_lastkey = vk_right{
        vspeed = PLspeed;
        hspeed = 0;
    }
//normal colisions
/*
if keyboard_check(vk_right){
        hspeed = 0;
    }else if keyboard_check(vk_left){
        hspeed = 0;
}
    
if keyboard_check(vk_up){
        vspeed = 0;
    }else if keyboard_check(vk_down){
        vspeed = 0;
}*/