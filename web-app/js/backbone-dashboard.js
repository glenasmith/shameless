$(function() {

    // Model
    var Meal = Backbone.Model.extend({
                url: function() {
                    return this.id ? MEAL.api + '/' + this.id : MEAL.api;
                },

                defaults: {
                    status: '',
                    longitude: '',
                    latitude: ''
                },

                initialize: function() {
                    console.log("Read Meal: " + this.get("status"));
                }

            });

    // Collection
    var MealCollection = Backbone.Collection.extend({

                model: Meal,
                url: MEAL.api

            });



	//View
    var MealView = Backbone.View.extend({
    	tagName: "li",
    	
    	template: Handlebars.compile( $("#mealTemplate").html() ),
    	
	    events: {
	        "click .delete": "deleteMeal",
	        "click .edit" : "editMeal",
            "click .toggleBad" : "toggleBad",
            "blur .statusField" : "updateMeal"
	    },
	    initialize: function () {
	        _.bindAll(this, "render", "deleteMeal", "editMeal", "updateMeal", "toggleBad");
	    },
	    render: function () {
	        var mealHtml = this.template(this.model.toJSON());
	        $(this.el).append(mealHtml);
	        return this;
	    },
        updateMeal: function() {
             var newStatus = this.$(".statusField").val();
             console.log("Updating status to " + newStatus);
	    	 this.model.set({status: newStatus });
	    	 this.model.save();
        },
	    deleteMeal: function () {
	    	var answer = confirm("Are you sure you want to delete this entry? This cannot be undone.");
	    	if (answer) {
	    		this.model.destroy();
	    	}
	        
	    },
        toggleBad: function() {
            var newBad = (this.$(".toggleBad").is(":checked")) ? "true" : "false";
            console.log("Updating badness value to " + newBad);
	    	 this.model.set({badFood: newBad });
	    	 this.model.save();
        },
	    editMeal: function() {
	    	
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
	
	
    var MealCollectionView = Backbone.View.extend({

                events: {
                    "click #bbRefresh": "add"
                },

                initialize: function() {
                    console.log("Sparking up on list: ")
                    console.log(this.el)
                     _.bindAll(this, 'render', 'add');
    				this.collection.bind('all', this.render);

                },

                render: function() {

                    var mealListUL = this.el
                    mealListUL.html(""); // clear existing entries for rerender
                    this.collection.each(function (oneMeal) {
                    	var nextMeal = new MealView({model: oneMeal});
                    	var renderedMeal = nextMeal.render().el
                        if (oneMeal.id == 1) {
                            console.log("Inspect this:")
                            console.log(renderedMeal);
                            console.log("Done");
                            console.log($(this.el));
                        }
                        mealListUL.append(renderedMeal);
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
            
            


     var DetailView = Backbone.View.extend({

                template: Handlebars.compile( $("#detailTemplate").html() ),

                events: {
                    "click #closeDetail": "close"
                },

                initialize: function() {
                     _.bindAll(this, 'render', 'add', 'close');

                },

                render: function() {
                    $(this.el).html(""); // wipe existing
                    $(this.el).append(this.template(this.model.toJSON()));
	                return this;
                },

                remove: function() {
                	$(this.el).remove();
                },
                close: function() {
                   mealApp.navigate("", true);
                },

                add: function() {
                	$("#new-zone-form-dialog").dialog("open");
                }


            });



	
	// Controller
    var MealRouter = Backbone.Router.extend({
    	routes: {
        	"": "allMeals",
        	"meal/:id": "oneMeal"
    	},
    	initialize: function (options) {
 
    	},
    	mealList: new MealCollection,
    	allMeals: function () {
        	var view = new MealCollectionView({ collection: this.mealList, el: $("#mealList") });
        	this.mealList.fetch();
    	},
    	oneMeal: function (id) {
            var detail = this.mealList.get(id)
            if (!detail) {
                detail = new Meal({"id": id});
                detail.fetch({async: false});
            } else {
                // we fetched from the cache...
            }
            var view = new DetailView({ model: detail, el: $("#mealList") });
            view.render();
    	}
	});

  

    // Start the backbone app
    var mealApp = new MealRouter;

	// And start all the magic....    
    Backbone.history.start();
    
});