package react

import grails.rest.Resource

@Resource(uri = '/Tasks')
class Tasks {
    String nome
    String descricao


    static constraints = {
    }
}
