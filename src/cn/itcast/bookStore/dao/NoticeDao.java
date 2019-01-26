package cn.itcast.bookStore.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.itcast.bookStore.domain.Notice;

public class NoticeDao extends HibernateDaoSupport{
	public List<Notice> getAllNotices() throws SQLException{
		String sql= "from Notice";
		Session session = this.getSession();
		Query query = session.createQuery(sql);
		query.setFirstResult(0);
		query.setMaxResults(10);
		return query.list();
	}
	public void addNotice(Notice n) throws SQLException{
		this.getHibernateTemplate().save(n);
	}
	public Notice findNoticeById(String n_id) throws SQLException{
		return this.getHibernateTemplate().get(Notice.class,Integer.parseInt(n_id));
		
	}
	public void deleteNotice(String n_id) throws SQLException{
		Notice n=this.findNoticeById(n_id);
		this.getHibernateTemplate().delete(n);
	}
	public void updateNotice(Notice n) throws Exception{
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(n);
		
	}
	

}
