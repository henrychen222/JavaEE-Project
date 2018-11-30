package com.yz.service.impl;

import java.util.List;

import com.yz.dao.NewsDao;
import com.yz.dao.impl.NewsDaoImpl;
import com.yz.domain.News;
import com.yz.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao newDao=new NewsDaoImpl();
    
	/* (non-Javadoc)
	 * @see com.yz.service.impl.NewsService#addNew(com.yz.domain.News)
	 */
	public int addNew(News news){
		return newDao.addNew(news);
		
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.NewsService#findAllNews()
	 */
	public List<News>findAllNews(){
		return newDao.findAllNews();
		
	}
	public List<News> findOne2FiveNews(){
		return newDao.findOne2FiveNews();
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.NewsService#findNews(java.lang.String)
	 */
	public News findNews(String id){
		return newDao.findNews(id);
		
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.NewsService#updateNews(com.yz.domain.News)
	 */
	public void updateNews(News news){
		newDao.updateNews(news);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.NewsService#deleteNews(java.lang.String)
	 */
	public void deleteNews(String id){
		newDao.deleteNews(id);
	}
	
}
