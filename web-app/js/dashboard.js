$(function() {

    // Model
    var Post = Backbone.Model.extend({
                url: function() {
                    return this.id ? POST.read + '/' + this.id : POST.read;
                },

                defaults: {
                    status: '',
                    longitude: '',
                    latitude: ''
                },

                initialize: function() {
                    console.log("Oh hey, Sparking up a POST! " + this.get("status"));  
                }

            });

    // Collection
    var PostCollection = Backbone.Collection.extend({

                model: Post,
                url: POST.read

            });



	//View
    var PostsView = Backbone.View.extend({

                events: {
                    "click #bbRefresh": "add"
                },

                initialize: function() {
                     _.bindAll(this, 'render', 'add');
    				this.collection.bind('all', this.render);
                },

                render: function() {
                    $(this.el).html(this.model.get("status"));
                    return this;
                },
                
                remove: function() {
                	$(this.el).remove();
                },
                
                add: function() {
                	$("#new-zone-form-dialog").dialog("open");
                }


            });
            
    var PostView = Backbone.View.extend({
    	tagName: "p",
    	
	    events: {
	        "click .delete": "deleteZone"
	    },
	    initialize: function () {
	        _.bindAll(this, "render", "edit");
	    },
	    render: function () {
	        //$(this.el).append($("#dns-zone-item-template").tmpl(this.model.toJSON()));
	        $(this.el).append(this.model.get("status")).append("<p/>");
	        return this;
	    },
	    deleteZone: function () {
	    	var answer = confirm("Are you sure you want to delete this entry? This cannot be undone.");
	    	if (answer) {
	    		this.model.destroy();
	    	}
	        
	    }
    	
	});
	
	// Controller
    var PostRouter = Backbone.Router.extend({
    	routes: {
        	"": "allposts",
        	"post/:id": "onepost"
    	},
    	initialize: function (options) {
 
    	},
    	postList: new PostCollection,
    	hostList: null,
    	allposts: function () {
    		alert("All posts was tripped");
        	var view = new PostsView({ collection: this.postList, el: $("#bbFoods") });
        	this.postList.fetch();
    	},
    	onepost: function (id) {
        	alert("Detail Post Not implemented yet");
    	}
	});

    // Application View

    var AppView = Backbone.View.extend({

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
    // window.App = new AppView;
    var postApp = new PostRouter;
    postApp.navigate("");
    
});