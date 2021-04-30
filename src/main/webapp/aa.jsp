<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/common/head.jsp" />
<body class="hold-transition sidebar-mini">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

    $(document).ready(function(){
        //form 서브밋
        $(".order").on("click",function(){

            Swal.fire({
                title: '발주를 계속 진행하겠습니까?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonText: '취소',
                confirmButtonText: '확인'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire(
                        '발주완료!',
                        'Your file has been completed.',
                        'success'
                    )
                }
            })//end swal


        });//end form


    });//end fn
</script>



<div class="wrapper">
    <!-- Sidebar -->
    <jsp:include page="/WEB-INF/common/sidebar.jsp" />

    <!-- Header -->
    <jsp:include page="/WEB-INF/ingredient/common/header.jsp" />

    <!-- Content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">발주관리 Page</h1>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div>
                        <strong>발주</strong> 부족한 재고를 발주 합니다.
                    </div>
                    <table class="table table-striped">
                        <thead>
                        <tr bgcolor="#BDBDBD" font color="white">
                            <th>품명</th>
                            <th>발주 요청 수량</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <select class="form-select" aria-label="Default select example">
                                    <option selected>추가하고 싶은 재고를 선택하세요</option>
                                    <option value="1">원두</option>
                                    <option value="2">시럽</option>
                                </select>
                            </td>
                            <td>
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="basic-addon1"></span>
                                    <input type="text" class="form-control" placeholder="발주 요청 수량" aria-label="order" aria-describedby="basic-addon1">
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>             <!-- /.row -->
                <div style="width:100px; height:50px; float:right">
                    <a href="#" class="order"><button type="button" class="btn btn-primary float-right">발주</button></a>
                </div>

            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content -->
    </div>

    <!-- Footer -->
    <jsp:include page="/WEB-INF/common/footer.jsp" />
</div>
</body>
</html>