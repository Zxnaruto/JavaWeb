package pers.zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.zx.entity.Ninja;
import pers.zx.utils.JdbcConnection;
import pers.zx.utils.NinjaBasicalImpl;
import pers.zx.utils.Page;

public class NinjaDaoImpl extends NinjaBasicalImpl implements NinjaDao{
	
	
	protected Connection connection;
    protected PreparedStatement pStatement;
    protected ResultSet rSet;
    
	/**
     * ��ȡ����
     */
    @Override
	public int getAmount() {
		// TODO Auto-generated method stub
		    connection = JdbcConnection.getConnection();
	        String sql = "SELECT COUNT(*) FROM Ninja";
	        int count = 0;
	        try {
	            pStatement = connection.prepareStatement(sql);
	            rSet = pStatement.executeQuery();
	            if(rSet.next()){
	                count = rSet.getInt(1);//�������
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            // ���ø��෽���ر���Դ
	            super.close();
	        }
	        return count;
	}
    /**
     * ��ȡ��ǰҳ������
     * @param page 
     * @return ����ǰҳ������
     */

	@Override
	public List<Ninja> getNinjaInfo(Page page) {
		// TODO Auto-generated method stub
		 connection = JdbcConnection.getConnection();
	        //����MySQL�ĺ����ķ�ҳ
	        String sql = "SELECT NinjaId,NinjaName,NinjaAge,NinjaSex,NinjaLevel FROM ninja LIMIT ?,?";
	        // ��������
	        List<Ninja> list = new ArrayList<Ninja>();
	        try {
	            pStatement = connection.prepareStatement(sql);
	            //������ز���,�����ݿ��д�start��ʼȡsize��
	            pStatement.setInt(1, page.getStart());
	            pStatement.setInt(2, page.getSize());
	            rSet = pStatement.executeQuery();
	            while(rSet.next()){
	               Ninja ninja = new Ninja();
	               ninja.setNinjaId(rSet.getInt("NinjaId"));
	               ninja.setNinjaName(rSet.getString("NinjaName"));
	               ninja.setNinjaAge(rSet.getInt("NinjaAge"));
	               ninja.setNinjaSex(rSet.getString("NinjaSex"));
	               ninja.setNinjaLevel(rSet.getString("NinjaLevel"));
	                list.add(ninja);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            // ���ø��෽���ر���Դ
	            super.close();
	        }
	        return list;
	    }

	}


