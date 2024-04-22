
package Utilities;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Utilities.DBconnection;
public class JDBCHeper {
    public static ResultSet excuteQuery(String sql , Object... args){
        Connection cn = null;
        ResultSet rs  = null;
        PreparedStatement pr  = null;
        
        cn = DBconnection.getConnection();
        try {
            pr = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pr.setObject(i+1,args[i]);
                
            }
            rs=pr.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }
        public static Integer excuteUpdate(String sql , Object... args){
        Connection cn = null;
        Integer row = 0;
        PreparedStatement pr  = null;
        
        cn = DBconnection.getConnection();
        try {
            pr = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pr.setObject(i+1,args[i]);
                
            }
            row=pr.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }
}
