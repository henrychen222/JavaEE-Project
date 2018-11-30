package com.yz.service;

import java.util.List;

import com.yz.domain.News;

public interface NewsService {

	public abstract int addNew(News news);

	public abstract List<News> findAllNews();

	public abstract News findNews(String id);

	public abstract void updateNews(News news);

	public abstract void deleteNews(String id);

	public abstract List<News> findOne2FiveNews();

} 