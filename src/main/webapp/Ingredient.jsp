<%@ page import="com.acorn.cafe.Ingredient.service.IngredientService" %>
<%@ page import="com.acorn.cafe.Ingredient.dto.IngredientDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/common/head.jsp" />
<body class="hold-transition sidebar-mini">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<script type="text/javascript">
    //CheckBox Select Fn
    var checkedList =new Array()
    $(document).ready(function(){
        // Select/Deselect checkboxes
        var checkbox = $('table tbody input[type="checkbox"]');
        $("#selectAll").click(function(){
            checkedList=[]
            if(this.checked){
                checkbox.each(function(){
                    this.checked = true;
                });
                var options = document.getElementsByName('ids')
                for (i=0 ; i<options.length; i++){
                    checkedList.push(options[i].innerText)
                }
                console.log(checkedList)
            }

            else{
                checkbox.each(function(){
                    this.checked = false;
                });
            }
        });
        checkbox.click(function(){
            if(!this.checked){
                $("#selectAll").prop("checked", false);
            }
            var check = $(this);
            var tr = check.parent().parent().parent()
            var td  = tr.children()
            var tdArr = new Array()

            for (i = 1 ; i<td.length-1; i++)
                tdArr.push(td[i].innerHTML)
            checkedList.push(tdArr[0])
            console.log(checkedList)
            console.log(tdArr)

        });
        $(".deleteAll").click(function (){
            console.log(checkedList)
            $("#delete_list").val(checkedList)
        })
        $(".delete").click(function (){
            var checkBtn = $(this);
            // checkBtn.parent() : checkBtn의 부모는 <td>이다.
            // checkBtn.parent().parent() : <td>의 부모이므로 <tr>이다.
            var tr = $(this).parent().parent();
            var td = tr.children();
            $('#delete_id').val(td[1].innerHTML)
        })
        $(".update").click(function (){
            var checkBtn = $(this);
            var tr = $(this).parent().parent();
            var td = tr.children();
            var tdArr= new Array();
            for (i = 1 ; i<td.length-1; i++)
                tdArr.push(td[i].innerHTML)
            $('#update_id').val(td[1].innerHTML)
            $('#update_name').val(td[2].innerHTML)
            $('#update_quantity').val(td[3].innerHTML)
            $('#update_partner').val(td[4].innerHTML)
            $('#update_price').val(td[6].innerHTML)
            $('#update_unit').val(td[5].innerHTML)
        })
    });//end CheckBox Select Fn
</script>
<div class="wrapper">
    <!-- Sidebar -->
    <jsp:include page="/WEB-INF/common/sidebar.jsp" />
    <link rel="stylesheet" type="text/css" href="css/checkbox.css">

    <!-- Content -->
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
                            <h1 class="m-0">재고관리 Page</h1>
                        </div><!-- /.col -->
                        <div class="col-sm-6">
                            <ll class="breadcrumb float-sm-right">
                                <button type="button" data-toggle="modal" data-target="#createModal" class="btn btn-primary float-right" style="WIDTH: 45pt; HEIGHT: 30pt; FONT-SIZE:10pt;">추가</button>
                                <a href="#deleteAllModal" class="deleteAll" data-toggle="modal"><button type="button" class="btn btn-primary float-right" style="WIDTH: 45pt; HEIGHT: 30pt; FONT-SIZE:10pt;" data-toggle="tooltip" title="Delete">삭제</button></a>
                            </ll>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div><!-- /.container-fluid -->
            </div>
        <!-- /.content-header -->
        <%
            IngredientService service = new IngredientService();
            List<IngredientDTO> dto =service.selectAll();
        %>
        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div>
                        <strong>재고관리</strong> 현재 재고 현황을 보여줍니다.
                    </div>
                    <table class="table table-striped" id = ingredientTable>
                        <thead>
                        <tr class="bg-dark-gray">
                            <th>
                                <span class="custom-checkbox">
									<input type="checkbox" id="selectAll">
									<label for="selectAll"></label>
								</span>
                            </th>
                            <th>번호</th>
                            <th>품명</th>
                            <th>재고</th>
                            <th>판매처</th>
                            <th>재고 단위</th>
                            <th>개당 가격</th>
                            <th>총합 가격</th>
                            <th>수정/삭제</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (IngredientDTO a : dto){
                        %>
                        <tr>
                            <td>
                               	<span class="custom-checkbox">
									<input type="checkbox" id="checkbox<%=a.getId()%>" name="options[]" value="<%=a.getId()%>">
									<label for="checkbox<%=a.getId() %>"></label>
								</span>
                            </td>
                            <td name="ids" value="<%=a.getId()%>"><%=a.getId()%></td>
                            <td ><%=a.getName()%></td>
                            <td ><%=a.getQuantity()%></td>
                            <td ><%=a.getPartner()%></td>
                            <td><%=a.getUnit()%></td>
                            <td><%=a.getPrice()%></td>
                            <% int totalPrice =a.getQuantity() * a.getPrice();
                            %>
                            <td><%=totalPrice%></td>
                            <td>
                                <a href="#updateModal" class="update" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="update">&#xE254;</i></a>
                                <a href="#deleteModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>

                            </td>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- /.row -->
        </div><!-- /.container-fluid -->
                    <br><br>
                    <div class="text-center">
                        <ul class="pagination justify-content-center">
                            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">4</a></li>
                            <li class="page-item"><a class="page-link" href="#">5</a></li>
                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                        </ul>
            </div>
        </div>
        <!-- /.content -->
        <jsp:include page="/WEB-INF/ingredient/modal/modalSet.jsp"></jsp:include>

        <!-- Footer -->
    <jsp:include page="/WEB-INF/common/footer.jsp" />
</div>
</body>
</html>
