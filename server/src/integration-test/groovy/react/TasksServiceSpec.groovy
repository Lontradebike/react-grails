package react

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class TasksServiceSpec extends Specification {

    TasksService tasksService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Tasks(...).save(flush: true, failOnError: true)
        //new Tasks(...).save(flush: true, failOnError: true)
        //Tasks tasks = new Tasks(...).save(flush: true, failOnError: true)
        //new Tasks(...).save(flush: true, failOnError: true)
        //new Tasks(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tasks.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        tasksService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Tasks> tasksList = tasksService.list(max: 2, offset: 2)

        then:
        tasksList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tasksService.count() == 5
    }

    void "test delete"() {
        Long tasksId = setupData()

        expect:
        tasksService.count() == 5

        when:
        tasksService.delete(tasksId)
        datastore.currentSession.flush()

        then:
        tasksService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Tasks tasks = new Tasks()
        tasksService.save(tasks)

        then:
        tasks.id != null
    }
}
