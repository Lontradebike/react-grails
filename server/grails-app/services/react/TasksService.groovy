package react

import grails.gorm.services.Service

@Service(Tasks)
interface TasksService {

    Tasks get(Serializable id)

    List<Tasks> list(Map args)

    Long count()

    Tasks delete(Serializable id)

    Tasks save(Tasks tasks)

}
