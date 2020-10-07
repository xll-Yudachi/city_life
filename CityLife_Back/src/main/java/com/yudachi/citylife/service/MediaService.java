package com.yudachi.citylife.service;

import com.yudachi.citylife.dao.MediaDao;
import com.yudachi.citylife.dto.MediaListQuery;
import com.yudachi.citylife.pojo.Media;

import java.util.List;

public class MediaService {
    public List<Media> findAllMedia(MediaListQuery query) {
        MediaDao mediaDao = new MediaDao();
        List<Media> allMedia = mediaDao.findAllMedia(query);
        return allMedia;
    }
}
