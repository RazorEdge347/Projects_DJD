if  sqrt(power(Player.x - x,2)+power(Player.y - y,2)) < 40{
    speed = 0;
    image_speed = 0;
    image_index = 0;
    }else{
    image_speed = 0.1;
    move_towards_point(Player.x, Player.y, PLspeed);
}

if  sqrt(power(Player.x - x,2)+power(Player.y - y,2)) < 32{
    speed = -Player.speed;
}

/*if  speed = 0{
    x += random_range(-0.05,0.05);
    y += random_range(-0.05,0.05);
}*/