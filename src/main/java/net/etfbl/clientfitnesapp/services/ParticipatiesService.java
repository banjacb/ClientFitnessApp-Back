package net.etfbl.clientfitnesapp.services;

import net.etfbl.clientfitnesapp.base.CrudService;

public interface ParticipatiesService extends CrudService<Integer> {
    void sendEmailNotification(Integer idUser, Integer categoryId);
}
