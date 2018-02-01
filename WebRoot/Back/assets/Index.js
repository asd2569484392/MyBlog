function getArticleList(json) {
	var articleTable = document.getElementById("articleTable");
	var blogTable = document.getElementById("blogTable");
	var draftsTable = document.getElementById("draftsTable");
	var informalEssayTable = document.getElementById("informalEssayTable");
			if(json["articleList"].length!=0||json["draftsList"].length!=0||json["BlogList"].length != 0
					||json["informalEssay"].length!=0) {
			for(var i = 0; i<3;i++){
				for(var k = 0; k < 3; k++) {
				var article_tr = document.createElement("tr");
				var article_td_1 = document.createElement("td");
				var article_td_2 = document.createElement("td");
				var article_td_3 = document.createElement("td");
				var article_td_4 = document.createElement("td");
				article_td_1.innerHTML = json["articleList"][k].id;
				article_td_2.innerHTML = json["articleList"][k].article_title;
				article_td_3.innerHTML = json["articleList"][k].article_keyword;
				article_td_4.innerHTML = json["articleList"][k].article_time;
				article_tr.appendChild(article_td_1);
				article_tr.appendChild(article_td_2);
				article_tr.appendChild(article_td_3);
				article_tr.appendChild(article_td_4);
				articleTable.appendChild(article_tr);
				var blog_tr = document.createElement("tr");
				var blog_td_1 = document.createElement("td");
				var blog_td_2 = document.createElement("td");
				var blog_td_3 = document.createElement("td");
				var blog_td_4 = document.createElement("td");
				blog_td_1.innerHTML = json["BlogList"][k].id;
				blog_td_2.innerHTML = json["BlogList"][k].blog_title;
				blog_td_3.innerHTML = json["BlogList"][k].blog_keyword;
				blog_td_4.innerHTML = json["BlogList"][k].blog_time;
				blog_tr.appendChild(blog_td_1);
				blog_tr.appendChild(blog_td_2);
				blog_tr.appendChild(blog_td_3);
				blog_tr.appendChild(blog_td_4);
				blogTable.appendChild(blog_tr);
				var draft_tr = document.createElement("tr");
				var draft_td_1 = document.createElement("td");
				var draft_td_2 = document.createElement("td");
				var draft_td_3 = document.createElement("td");
				var draft_td_4 = document.createElement("td");
				draft_td_1.innerHTML = json["draftsList"][k].id;
				draft_td_2.innerHTML = json["draftsList"][k].draft_title;
				draft_td_3.innerHTML = json["draftsList"][k].draft_type;
				draft_td_4.innerHTML = json["draftsList"][k].draft_time;
				draft_tr.appendChild(draft_td_1);
				draft_tr.appendChild(draft_td_2);
				draft_tr.appendChild(draft_td_3);
				draft_tr.appendChild(draft_td_4);
				draftsTable.appendChild(draft_tr);
				var informalEssayTable_tr = document.createElement("tr");
				var informalEssayTable_td_1 = document.createElement("td");
				var informalEssayTable_td_2 = document.createElement("td");
				var informalEssayTable_td_3 = document.createElement("td");
				var informalEssayTable_td_4 = document.createElement("td");
				informalEssayTable_td_1.innerHTML = json["informalEssay"][k].id;
				informalEssayTable_td_2.innerHTML = json["informalEssay"][k].informalessay_title;
				informalEssayTable_td_3.innerHTML = json["informalEssay"][k].informalessay_author;
				informalEssayTable_td_4.innerHTML = json["informalEssay"][k].informalessay_time;
				informalEssayTable_tr.appendChild(informalEssayTable_td_1);
				informalEssayTable_tr.appendChild(informalEssayTable_td_2);
				informalEssayTable_tr.appendChild(informalEssayTable_td_3);
				informalEssayTable_tr.appendChild(informalEssayTable_td_4);
				informalEssayTable.appendChild(informalEssayTable_tr);
			}
			
		}
			}
	}

/*function getDraftsList(json) {
	if(json["draftsList"][i].id != null) {
		for(var i = 0; i < 3; i++) {
			for(var k = 0; k < 3; k++) {
				
			}
		}
	}
};
function getInformalEssaysList(json){
	
};
*/