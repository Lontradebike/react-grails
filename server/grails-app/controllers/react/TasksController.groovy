package react

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class TasksController {

    TasksService tasksService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tasksService.list(params), model:[tasksCount: tasksService.count()]
    }

    def show(Long id) {
        respond tasksService.get(id)
    }

    @Transactional
    def save(Tasks tasks) {
        if (tasks == null) {
            render status: NOT_FOUND
            return
        }
        if (tasks.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tasks.errors
            return
        }

        try {
            tasksService.save(tasks)
        } catch (ValidationException e) {
            respond tasks.errors
            return
        }

        respond tasks, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Tasks tasks) {
        if (tasks == null) {
            render status: NOT_FOUND
            return
        }
        if (tasks.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tasks.errors
            return
        }

        try {
            tasksService.save(tasks)
        } catch (ValidationException e) {
            respond tasks.errors
            return
        }

        respond tasks, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || tasksService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
