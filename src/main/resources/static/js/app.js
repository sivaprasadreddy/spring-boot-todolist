new Vue({
    el: '#app',
    data: {
        todos: [],
        newTodo: {}
    },
    created: function () {
        this.loadTodos();
    },
    methods: {
        loadTodos() {
            let self = this;
            $.getJSON("api/todos", function (data) {
                self.todos = data
            });
        },

        saveTodo() {
            let self = this;

            $.ajax({
                type: "POST",
                url: 'api/todos',
                data: JSON.stringify(this.newTodo),
                contentType: "application/json",
                success: function () {
                    self.newTodo = {};
                    self.loadTodos();
                }
            });
        },

        deleteTodo(id) {
            let self = this;

            $.ajax({
                type: "DELETE",
                url: 'api/todos/' + id,
                success: function () {
                    self.loadTodos();
                }
            });
        }
    },
    computed: {}
});
