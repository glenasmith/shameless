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
	        _.bindAll(this, "render", "deletePost", "editPost");
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
	    editPost: function() {
	    	
	    	// populate the dialog values
	    	$("#status").val(this.model.get("status"));
	    	
	    	// bind the model to the dialog
	    	$( "#dialog-form" ).data("model", this.model);
	    	
	    	$( "#dialog-form" ).dialog({
				autoOpen: false,
				height: 300,
				width: 350,
				modal: true,
				buttons: {
					"Update": function() {
							var model = $( "#dialog-form" ).data("model");
							var newStatus = $("#status").val();
	    					model.set({status: newStatus });
	    					model.save();
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
                    $(this.el).html("<table id='bbFoods'/>"); // create holder for the view, blanking existing content
                	var bbFoods = $("#bbFoods");
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
            
            
    var ToolbarView = Backbone.View.extend({

                template: Handlebars.compile( $("#mainToolbarTemplate").html() ),

                events: {
                    "click #addEntry": "add"
                },

                initialize: function() {
                     _.bindAll(this, 'render', 'add');
    				this.collection.bind('all', this.render);
                },

                render: function() {
                    $(this.el).html(""); // wipe existing
                	$(this.el).append(this.template([]));
                    return this;
                },
                
                add: function() {
                	// blank the dialog values
			    	$("#status").val("");
			    	
			    	// bind the model to the dialog
			    	$( "#dialog-form" ).data("collection", this.collection);
			    	
			    	$( "#dialog-form" ).dialog({
						autoOpen: false,
						height: 300,
						width: 350,
						modal: true,
						buttons: {
							"Create": function() {
									var collection = $( "#dialog-form" ).data("collection");
									var newStatus = $("#status").val();
									var post = new Post;
									post.set({status: newStatus});
									post.save();
			    					collection.add(post);
			    					
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
            


    var DetailToolbarView = Backbone.View.extend({

                template: Handlebars.compile( $("#detailToolbarTemplate").html() ),

                events: {
                    "click #closeEntry": "close"
                },

                initialize: function() {
                     _.bindAll(this, 'render', 'close');
    				//this.collection.bind('all', this.render);
                },

                render: function() {
                    $(this.el).html(""); // wipe existing
                    $(this.el).append(this.template([]));
	                return this;
                },


                close: function() {
                	// nav back to the home page
			    	postApp.navigate("", true);
                }


            });

     var DetailView = Backbone.View.extend({

                template: Handlebars.compile( $("#detailTemplate").html() ),

                events: {
                    "click #bbRefresh": "add"
                },

                initialize: function() {
                     _.bindAll(this, 'render', 'add');

                },

                render: function() {
                    $(this.el).html(""); // wipe existing
                    $(this.el).append(this.template(this.model.toJSON()));
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
    	allposts: function () {
        	var view = new PostsView({ collection: this.postList, el: $("#bbBody") });
        	var toolbar = new ToolbarView({ collection: this.postList, el: $("#bbToolbar") });
        	this.postList.fetch();
    	},
    	onepost: function (id) {
            var detail = this.postList.get(id)
            if (!detail) {
                detail = new Post({"id": id});
                detail.fetch({async: false});
            } else {
                // we fetched from the cache...
            }
            var view = new DetailView({ model: detail, el: $("#bbBody") });
            view.render();
        	var toolbar = new DetailToolbarView({ el: $("#bbToolbar") });
            toolbar.render();
    	}
	});

  

    // Start the backbone app
    var postApp = new PostRouter;

	// And start all the magic....    
    Backbone.history.start();
    
});