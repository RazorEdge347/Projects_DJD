package pt.ipb.esact.compgraf.ObjectList;

import com.jogamp.opengl.util.gl2.GLUT;
import pt.ipb.esact.compgraf.tools.GlTools;


import javax.media.opengl.GL2;
import javax.vecmath.Vector3f;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by MateusBranco on 17/02/2017.
 */
public class ColisionBox2D {
    Vector3f aa;
    Vector3f ab;
    Vector3f ba;
    Vector3f bb;

    /*AA------AB
    **|        |
    **|        |
    **BA------BB
     */

    float h05;
    float w05;
    Vector3f Center;

    public ColisionBox2D(Vector3f objCenter, float width, float height) {
        Center = objCenter;
        if(width != 0 && height != 0){
            w05 = width * 0.5f;
            h05 = height * 0.5f;
            aa = new Vector3f(objCenter.x - (w05), 0, objCenter.z + h05);
            ab = new Vector3f(objCenter.x + (w05), 0, objCenter.z + h05);
            ba = new Vector3f(objCenter.x - (w05), 0, objCenter.z - h05);
            bb = new Vector3f(objCenter.x + (w05), 0, objCenter.z - h05);
        }
    }

    /*public Vector3f Drawbox(int vert){
        if(vert == 1) {
            return aa;
        }else if(vert == 2) {
            return ab;
        }else if(vert == 3) {
            return ba;
        }else if(vert == 4) {
            return bb;
        }else if(vert == 0) {
            return Center;
        }
        return null;
    }*/

    public Vector3f getHW(){
        return new Vector3f(h05,0,w05);
    }
}


