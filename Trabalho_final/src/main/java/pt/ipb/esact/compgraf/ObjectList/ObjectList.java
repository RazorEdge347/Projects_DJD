package pt.ipb.esact.compgraf.ObjectList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.Lists;
import pt.ipb.esact.compgraf.engine.obj.ObjLoader;
import pt.ipb.esact.compgraf.tools.DefaultGLWindow;
import pt.ipb.esact.compgraf.tools.GlTools;
import pt.ipb.esact.compgraf.ObjectList.ColisionBox2D;

import javax.vecmath.Vector3f;

import static java.text.MessageFormat.format;

/**
 * Created by MateusBranco on 17/02/2017.
 */
public class ObjectList {

    private int objID = 0;

    private List<ObjLoader> ObjectList = Lists.newArrayList();
    private List<String> Objectname = Lists.newArrayList();
    private List<ColisionBox2D> ColBoxList = Lists.newArrayList();

    public void AddObject(DefaultGLWindow DfGlW, String name, String obj, String mtl, float width, float height){
        //checkNotNull(DfGlW);
        //Verify name existence
        /*if(objID != 0){
            if(getObject(name) == null){
                GlTools.exit("Object name already exists");
            }
        }*/
        ObjLoader newObj;
        //System.out.println(DfGlW);

        //Verify obj and mtl file path.
        boolean mtlLoaded = false;
        boolean objLoaded= false;
        try(BufferedReader modelStream = new BufferedReader(new FileReader(obj))) {
            String line = null;
            List<String> modelLines = Lists.newArrayList();
            while((line = modelStream.readLine()) != null)
                modelLines.add(line);
            objLoaded = true;
            System.out.println(name + " model was Loaded sucessfully");
        }catch (IOException e){
            GlTools.exit(format("Cunt Error reading material from ''{0}'': {1}", obj, e.getMessage()));
        }

        try(BufferedReader materialStream = new BufferedReader(new FileReader(obj))) {
            String line = null;
            List<String> modelLines = Lists.newArrayList();
            while((line = materialStream.readLine()) != null)
                modelLines.add(line);
            mtlLoaded = true;
            System.out.println(name + " Texture was Loaded sucessfully");
        }catch (IOException e){
            GlTools.exit(format("Baka Error reading material from ''{0}'': {1}", mtl, e.getMessage()));
        }

        //If Paths loaded Create obj and add to list.
        if(mtlLoaded && objLoaded){
            newObj = new ObjLoader(DfGlW);
            newObj.load(obj, mtl);

            //if(width != 0 & height != 0){
                //ADD COLISION BOX(Square)
                Vector3f Center = newObj.getobjCenter();//new Vector3f(newObj.getobjCenter().x,newObj.getobjCenter().y,newObj.getobjCenter().z);
                ColisionBox2D newBox =  new ColisionBox2D(Center,width,height);
                ColBoxList.add(objID,newBox);
                //objID++;
            //}
            ObjectList.add(objID,newObj);
            Objectname.add(objID,name);
            System.out.println("List Size: " + Objectname.size());
            System.out.println("Object " + name + " was added to the list with ID: "+ objID);
            objID++;
        }
    }

    //Search and return object by name.
    public ObjLoader getObject(String name){
        int i = 0;
        while(i < Objectname.size()){
            if(Objectname.get(i) == name){
                return ObjectList.get(i);
            }else{
                i++;
            }
        }
        return null;
    }

    public String getObjNameByIndex(int Index){
            return Objectname.get(Index);
    }

    public ColisionBox2D getObjectBox(String name){
        int i = 0;
        while(i < Objectname.size()){
            if(Objectname.get(i) == name){
                return ColBoxList.get(i);
            }else{
                i++;
            }
        }
        return null;
    }

    public boolean checkColisions(String objname1, String objname2) {
        if((objname1 != objname2)){
            ColisionBox2D box1 = getObjectBox(objname1);
            ColisionBox2D box2 = getObjectBox(objname2);

            Vector3f obj1 = getObject(objname1).getobjCenter();
            Vector3f obj2 = getObject(objname2).getobjCenter();
            //check closest
            if (Math.abs(obj1.x - obj2.x) > (box1.getHW().x + box2.getHW().x)) return false;
            if (Math.abs(obj1.z - obj2.z) > (box1.getHW().z + box2.getHW().z)) return false;
            return true;
        }
        return false;
    }

    public int getMaxIndex(){
        return Objectname.size();
    }

    private Vector3f getcolisionPoint(){
        return new Vector3f(0,0,0);
    }

    /*public Vector3f drawColisionBox(ColisionBox2D Box, int vert){
        if(vert == 1) {
            return Box.Drawbox(1);
        }else if(vert == 2) {
            return Box.Drawbox(2);
        }else if(vert == 3) {
            return Box.Drawbox(3);
        }else if(vert == 4) {
            return Box.Drawbox(4);
        }else if(vert == 0) {
            return Box.Drawbox(5);
        }
        return null;
    }*/

}
