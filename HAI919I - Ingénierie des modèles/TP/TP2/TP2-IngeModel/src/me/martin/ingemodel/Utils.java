package me.martin.ingemodel;

import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Class;
public class Utils {
		
	public static Class findClassInPackage(String name, Package p){
        Class c = null;
        for (PackageableElement pd : p.getPackagedElements()){
            if (pd instanceof Class){
                Class pdc = (Class) pd;
                if (pdc.getName().equals(name)){return pdc;}
            } else if (pd instanceof Package) {
                Package pdp=(Package)pd;
                c=findClassInPackage(name, pdp);
                if (c!=null){return c;}
            }
        }
        return c;
    }
 
    public static Package findPackageInPackage(String name, Package p){
        Package result = null;
        for (PackageableElement pd : p.getPackagedElements()){
             if (pd instanceof Package) {
                Package pdp = (Package) pd;
                if (pdp.getName().equals(name)){return pdp;}
                result=findPackageInPackage(name, pdp);
                if (result!=null){return result;}
            }
        }
        return result;
    }
}
