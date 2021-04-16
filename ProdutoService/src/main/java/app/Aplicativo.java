package app;

import static spark.Spark.*;


import service.ProdutoService;
import spark.Route;



public class Aplicativo {
	private static ProdutoService produtoService = new ProdutoService();

	public static void main(String[] args) {
		port(4567);
		
		post("/produto", (request, response) -> produtoService.add(request, response));

		get("/produto/:id", (request, response) -> produtoService.get(request, response));

		get("/produto/update/:id", (request, response) -> produtoService.update(request, response));

		get("/produto/delete/:id", (request, response) -> produtoService.remove(request, response));

		get("/produto1", (request, response) -> produtoService.getAll(request, response)+ request.body());

	}
	
	

}


