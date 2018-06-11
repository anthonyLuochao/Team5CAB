<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Confirm Facility Create</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <cab:headImports />
</head>

<body>
    <cab:nav/>

    <!--End of template-->

    <h1 style="text-align: center;">Facility Create Confirmation</h1>
    <hr>
    <div class="container">
        <form:form action="" method="post" class="col-12 card-body needs-validation" novalidate>
            <p class="text-muted font-italic mb-0 pb-0">Facility ID</p>
            <h5 class="">{facility.facilityID}</h5>

            <p class="text-muted font-italic mb-0 pb-0">Facility Type</p>
            <h5 class="">{facility.facilityType}</h5>

            <p class="text-muted font-italic mb-0 pb-0">Facility Name</p>
            <h5 class="">{facility.facilityName}</h5>

            <p class="text-muted font-italic mb-0 pb-0">Address</p>
            <h5 class="">{facility.address}</h5>

            <p class="text-muted font-italic mb-0 pb-0">Address</p>
            <h5 class="mb-5">{facility.description}
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Aspernatur aliquid unde repudiandae culpa eos tempore eligendi aut.
                Sapiente facere debitis laboriosam quo nobis saepe odio voluptates ad hic, aspernatur maiores! Ullam, eaque
                vero id animi alias enim porro molestiae quod quam fugit saepe! Esse cupiditate quos earum eos, nobis fugiat
                dignissimos suscipit nesciunt neque ipsa quis, voluptatem sapiente aliquam amet. Atque, enim adipisci molestias
                est quo voluptas fugiat aperiam ex nam vitae, saepe dolor reiciendis ipsam quam harum nisi ducimus quos reprehenderit
                quasi consectetur recusandae? Sunt illum alias facilis debitis?</h5>

                <div class="text-center">
                    <button type="submit" id='validateDate' class="btn " formaction="./create">Back to Create Facility</button>
                    <button type="submit" id='validateDate' class="btn " formaction="../welcome">Home</button>
                </div>
        </form:form>
    </div>
</body>
</html>
