$(function() {

    // Model
    window.Post = Backbone.Model.extend({
                url: function() {
                    return this.id ? '/shameless/post/' + this.id : '/shameless/post.json';
                },

                defaults: { post: {
                    status: 'None entered',
                    longitude: '',
                    latitude: ''
                }},

                initialize: function() {
                    // can be used to initialize model attributes
                }

            });

    // Collection

    window.PostCollection = Backbone.Collection.extend({

                model: Post,
                url: '/shameless/posts.json'

            });

    window.Posts = new PostCollection;

    //View

    window.PostView = Backbone.View.extend({

                tagName: 'tr',

                events: {
                    // can be used for handling events on the template
                },

                initialize: function() {
                    //this.render();
                },

                render: function() {
                    var post = this.model.toJSON();
                    //Template stuff
                    $(this.el).html(post_template(post));
                    return this;
                }



            });

    // Application View

    window.AppView = Backbone.View.extend({

                el: $('#post_app'),

                events: {
                    "submit form":"createPost"
                },

                initialize: function() {
                    _.bindAll(this, 'addOne', 'addAll');

                    Posts.bind('add', this.addOne);
                    Posts.bind('refresh', this.addAll);
                    Posts.bind('all', this.render);

                    Posts.fetch();
                },

                addOne: function(post) {
                    var view = new PostView({model:post});
                    this.$('#book_table').append(view.render().el);
                },

                addAll: function() {
                    Posts.each(this.addOne);
                },

                newAttributes: function(event) {
                    return { post: {
                        status: $('#status').val(),
                        longitude: $('#longitude').val(),
                        latitude: $('#latitude').val()
                    }  }
                },

                createPost: function(e) {
                    e.preventDefault();
                    var params = this.newAttributes(e);
                    Posts.create(params)
                    //TODO clear form fields
                }
            });

    // Start the backbone app
    window.App = new AppView;
});