package dao;

import java.util.List;

import entity.StuInfo;

public class StuDAO {
	
	public List<StuInfo> listAll() {
		String sql = "select * from stuinfo";
		return BaseDao.preparedQuery(StuInfo.class, sql);
	}
	
	public List<StuInfo> fuzzyQuery(String name) {
		String sql = "select * from stuinfo where stuname like ?";
		return BaseDao.preparedQuery(StuInfo.class, sql, "%" + name + "%");
	}
	
	public void delete(String stuno) {
		String sql = "delete from stuinfo where stuno=?";
		BaseDao.preparedUpdate(sql, stuno);
	}
	
}
