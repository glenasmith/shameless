$(function() {

    // Model
    var Post = Backbone.Model.extend({
                url: function() {
                    return this.id ? POST.api + '/' + this.id : POST.api;
                },

                defaults: {
                    status: '',
                    longitude: '',
                    latitude: ''
                },

                initialize: function() {
                    console.log("Read Post: " + this.get("status"));  
                }

            });

    // Collection
    var PostCollection = Backbone.Collection.extend({

                model: Post,
                url: POST.api

            });



	//View
    var PostView = Backbone.View.extend({
    	tagName: "tr",
    	
    	template: Handlebars.compile( $("#rowTemplate").html() ),
    	
	    events: {
	        "click .delete": "deletePost",
	        "click .edit" : "editPost"
	    },
	    initialize: function () {
	        _.bindAll(this, "render", "updatePost", "editPost");
	    },
	    render: function () {
	        //var source = $("#rowTemplate").html();
	        //var template = Handlebars.compile(source);
	        
	        $(this.el).append(this.template(this.model.toJSON()));
	        return this;
	    },
	    deletePost: function () {
	    	var answer = confirm("Are you sure you want to delete this entry? This cannot be undone.");
	    	if (answer) {
	    		this.model.destroy();
	    	}
	        
	    },
	    updatePost: function(event, ui) {
	    	var newStatus = $("#status").val();
	    	alert("Setting new status to " + newStatus );
	    	this.model.set({status: newStatus });
	    	this.model.save();
	    },
	    editPost: function() {
	    	
	    	$("#status").val(this.model.get("status"));
	    	// $( "#dialog-form" ).data("model", this.model);
	    	$( "#dialog-form" ).bind("dialogclose", this.updatePost);
	    	
	    	
	    	$( "#dialog-form" ).dialog({
				autoOpen: false,
				height: 300,
				width: 350,
				modal: true,
				buttons: {
					"Update": function() {
						
							$( this ).dialog( "close" );
						
					},
					Cancel: function() {
						$( this ).dialog( "close" );
					}
					
				}
			});
			
			$( "#dialog-form" ).dialog( "open" );

	    	
	    	
	    }
    	
	});	
	
	
    var PostsView = Backbone.View.extend({

                events: {
                    "click #bbRefresh": "add"
                },

                initialize: function() {
                     _.bindAll(this, 'render', 'add');
    				this.collection.bind('all', this.render);
                },

                render: function() {
                	var bbFoods = $("#bbFoods").html(""); // blank out existing entries
                    this.collection.each(function (onePost) {
                    	var nextPost = new PostView({model: onePost});
                    	var renderedPost = nextPost.render().el
                    	bbFoods.append(renderedPost);
                	});
                    return this;
                },
                
                remove: function() {
                	$(this.el).remove();
                },
                
                add: function() {
                	$("#new-zone-form-dialog").dialog("open");
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
        	var view = new PostsView({ collection: this.postList, el: $("#bbFoods") });
        	this.postList.fetch();
    	},
    	onepost: function (id) {
        	alert("Detail Post Not implemented yet");
    	}
	});

  

    // Start the backbone app
    var postApp = new PostRouter;

	// And start all the magic....    
    Backbone.history.start();
    
});