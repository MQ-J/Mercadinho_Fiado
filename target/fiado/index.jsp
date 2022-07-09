<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Contas Pendentes</title>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/fiado">Fiado</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                    <a class="nav-link" href="/fiado/produtos">Produtos</a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="/fiado/clientes">Clientes</a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="/fiado/compras">Compras</a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="/fiado/pagamentos">Pagamentos</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="d-flex w-75 mx-auto mt-5 justify-content-around">
        <div class="card">
            <div class="card-body">
                <div class="lead">Valor em caixa</div>
                <h2 class="card-title text-success">R$ 1.057.891,53</h2>
                <p class="small text-muted">período: 01/05/22 - 01/06/22</p>
            </div>
        </div>
    
        <div class="card">
            <div class="card-body">
                <div class="lead">Funcionários logados</div>
                <h2 class="card-title text-success">3</h2>
                <p class="small text-muted">1 - Pedro Henrique (caixa)</p>
                <p class="small text-muted">2 - Samanta Alburquerque (financeiro)</p>
                <p class="small text-muted">3 - Maria Joana (Gerente loja 2)</p>
            </div>
        </div>
    </div>

    <div class="d-flex w-75 mx-auto mt-5 justify-content-around">
        <div class="card">
            <div class="card-body">
                <div class="lead">Atenção para o próximo imposto a ser pago:</div>
                <h2 class="card-title text-danger">ICMS</h2>
                <p class="small text-muted">O prazo para enviar os informes é até: <b>o próximo dia 20</b></p>
            </div>
        </div>
    </div>
    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
