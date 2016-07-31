package org.literacyapp.dao.jpa;

import java.util.List;

import javax.persistence.NoResultException;
import org.literacyapp.dao.VideoDao;

import org.springframework.dao.DataAccessException;

import org.literacyapp.model.content.multimedia.Video;
import org.literacyapp.model.enums.Locale;

public class VideoDaoJpa extends GenericDaoJpa<Video> implements VideoDao {

    @Override
    public Video read(String title, Locale locale) throws DataAccessException {
        try {
            return (Video) em.createQuery(
                "SELECT v " +
                "FROM Video v " +
                "WHERE v.title = :title " +
                "AND v.locale = :locale")
                .setParameter("title", title)
                .setParameter("locale", locale)
                .getSingleResult();
        } catch (NoResultException e) {
            logger.warn("Video \"" + title + "\" was not found for locale " + locale);
            return null;
        }
    }

    @Override
    public List<Video> readAllOrdered(Locale locale) throws DataAccessException {
        return em.createQuery(
            "SELECT v " +
            "FROM Video v " +
            "WHERE v.locale = :locale " +
            "ORDER BY v.title")
            .setParameter("locale", locale)
            .getResultList();
    }
}