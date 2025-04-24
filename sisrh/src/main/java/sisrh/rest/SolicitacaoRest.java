package sisrh.rest;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import io.swagger.annotations.*;
import sisrh.banco.Banco;
import sisrh.dto.Solicitacao;

@Api
@Path("/solicitacao")
public class SolicitacaoRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Lista todas as solicitações")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Lista de solicitações retornada com sucesso"),
        @ApiResponse(code = 500, message = "Erro ao listar solicitações")
    })
    public Response listarSolicitacoes() {
        try {
            List<Solicitacao> lista = Banco.listarSolicitacoes();
            GenericEntity<List<Solicitacao>> entity = new GenericEntity<List<Solicitacao>>(lista) {};
            return Response.ok().entity(entity).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao listar solicitações!\", \"detalhe\" : \"" + 
                           e.getMessage().replace("\"", "'") + "\" }").build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Obtém uma solicitação pelo ID")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Solicitação encontrada e retornada"),
        @ApiResponse(code = 404, message = "Solicitação não encontrada"),
        @ApiResponse(code = 500, message = "Erro ao obter solicitação")
    })
    public Response obterSolicitacao(@PathParam("id") Integer id) {
        try {
            Solicitacao solicitacao = Banco.buscarSolicitacaoPorId(id);
            if (solicitacao != null) {
                return Response.ok().entity(solicitacao).build();
            } else {
                return Response.status(Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitação não encontrada!\" }").build();
            }
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao obter solicitação!\", \"detalhe\" : \"" + 
                           e.getMessage().replace("\"", "'") + "\" }").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Inclui uma nova solicitação")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Solicitação incluída com sucesso"),
        @ApiResponse(code = 500, message = "Erro ao incluir solicitação")
    })
    public Response incluirSolicitacao(Solicitacao solicitacao) {
        try {
            Solicitacao novaSolicitacao = Banco.incluirSolicitacao(solicitacao);
            return Response.ok().entity(novaSolicitacao).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao incluir solicitação!\", \"detalhe\" : \"" + 
                           e.getMessage().replace("\"", "'") + "\" }").build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Altera uma solicitação existente")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Solicitação alterada com sucesso"),
        @ApiResponse(code = 404, message = "Solicitação não encontrada"),
        @ApiResponse(code = 500, message = "Erro ao alterar solicitação")
    })
    public Response alterarSolicitacao(@PathParam("id") Integer id, Solicitacao solicitacao) {
        try {
            if (Banco.buscarSolicitacaoPorId(id) == null) {
                return Response.status(Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitação não encontrada!\" }").build();
            }
            Solicitacao solicitacaoAtualizada = Banco.alterarSolicitacao(id, solicitacao);
            return Response.ok().entity(solicitacaoAtualizada).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao alterar solicitação!\", \"detalhe\" : \"" + 
                           e.getMessage().replace("\"", "'") + "\" }").build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Exclui uma solicitação")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Solicitação excluída com sucesso"),
        @ApiResponse(code = 404, message = "Solicitação não encontrada"),
        @ApiResponse(code = 500, message = "Erro ao excluir solicitação")
    })
    public Response excluirSolicitacao(@PathParam("id") Integer id) {
        try {
            if (Banco.buscarSolicitacaoPorId(id) == null) {
                return Response.status(Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitação não encontrada!\" }").build();
            }
            Banco.excluirSolicitacao(id);
            return Response.ok().entity("{ \"mensagem\" : \"Solicitação " + id + " excluída com sucesso!\" }").build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao excluir solicitação!\", \"detalhe\" : \"" + 
                           e.getMessage().replace("\"", "'") + "\" }").build();
        }
    }
}