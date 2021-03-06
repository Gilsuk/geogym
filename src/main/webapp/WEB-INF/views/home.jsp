<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img class="bd-placeholder-img" width="100%" height="100%"
				src="/resources/img/contest.jpg" >
				<rect width="100%" height="100%" fill="#777" />
			<div class="container">
				<div class="carousel-caption text-left">
					<h1>ONLINE QUALIFIER</h1>
					<p>The Online Qualifier is where individuals can earn their spot to compete at the 
					GEOGYM Invitational on January 10-20, 2020 through the GEOGYM Online Qualifier.</p>
					<p>
						<a class="btn btn-lg btn-primary" href="/page/participation" role="button">지원하기</a>
						
					</p>
				</div>
			</div>
		</div>
		<div class="carousel-item">
			<img class="bd-placeholder-img" width="100%" height="100%"
				src="/resources/img/cash1.jpg" >
				<rect width="100%" height="100%" fill="#777" />
			<div class="container">
				<div class="carousel-caption">
					<h1>캐쉬충전 어찌고 저찌고</h1>
					<p>이 사이트 이용할라믄 캐쉬충전해야함. 블라블라~~~~~</p>
					<p>
						<a class="btn btn-lg btn-primary" href="/payment/form" role="button">충전하러 GO</a>
					</p>
				</div>
			</div>
		</div>
		<div class="carousel-item">
			<img class="bd-placeholder-img" width="100%" height="100%"
				src="/resources/img/matching.jpg" >
				<rect width="100%" height="100%" fill="#777" />
			<div class="container">
				<div class="carousel-caption text-right">
					<h1>트레이너 매칭 어찌고 </h1>
					<p>블라블라</p>
					<p>
						<a class="btn btn-lg btn-primary" href="/trainer/list" role="button">매칭하기</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<a class="carousel-control-prev" href="#myCarousel" role="button"
		data-slide="prev"> <span class="carousel-control-prev-icon"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#myCarousel" role="button"
		data-slide="next"> <span class="carousel-control-next-icon"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</div>


<!-- Marketing messaging and featurettes
  ================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

	<!-- Three columns of text below the carousel -->
	<div class="row">
		<div class="col-lg-4">
			<svg class="bd-placeholder-img rounded-circle" width="140"
				height="140" xmlns="http://www.w3.org/2000/svg"
				preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
				aria-label="Placeholder: 140x140">
				<title>Placeholder</title><rect width="100%" height="100%"
					fill="#777" />
				<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
			<h2>Heading</h2>
			<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis
				euismod. Nullam id dolor id nibh ultricies vehicula ut id elit.
				Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
				Praesent commodo cursus magna.</p>
			<p>
				<a class="btn btn-secondary" href="#" role="button">View details
					&raquo;</a>
			</p>
		</div>
		<!-- /.col-lg-4 -->
		<div class="col-lg-4">
			<svg class="bd-placeholder-img rounded-circle" width="140"
				height="140" xmlns="http://www.w3.org/2000/svg"
				preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
				aria-label="Placeholder: 140x140">
				<title>Placeholder</title><rect width="100%" height="100%"
					fill="#777" />
				<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
			<h2>Heading</h2>
			<p>Duis mollis, est non commodo luctus, nisi erat porttitor
				ligula, eget lacinia odio sem nec elit. Cras mattis consectetur
				purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo,
				tortor mauris condimentum nibh.</p>
			<p>
				<a class="btn btn-secondary" href="#" role="button">View details
					&raquo;</a>
			</p>
		</div>
		<!-- /.col-lg-4 -->
		<div class="col-lg-4">
			<svg class="bd-placeholder-img rounded-circle" width="140"
				height="140" xmlns="http://www.w3.org/2000/svg"
				preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
				aria-label="Placeholder: 140x140">
				<title>Placeholder</title><rect width="100%" height="100%"
					fill="#777" />
				<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
			<h2>Heading</h2>
			<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
				egestas eget quam. Vestibulum id ligula porta felis euismod semper.
				Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
				nibh, ut fermentum massa justo sit amet risus.</p>k
			<p>
				<a class="btn btn-secondary" href="#" role="button">View details
					&raquo;</a>
			</p>
		</div>
		<!-- /.col-lg-4 -->
	</div>
	<!-- /.row -->


	<!-- START THE FEATURETTES -->

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7">
			<h2 class="featurette-heading">
				First featurette heading. <span class="text-muted">It’ll blow
					your mind.</span>
			</h2>
			<p class="lead">Donec ullamcorper nulla non metus auctor
				fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur. Fusce
				dapibus, tellus ac cursus commodo.</p>
		</div>
		<div class="col-md-5">
			<img
				class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
				width="500" height="500" src="/resources/img/food.jpg"  >
				<title>Placeholder</title><rect width="100%" height="100%"
					fill="#eee" />
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7 order-md-2">
			<h2 class="featurette-heading">
				Oh yeah, it’s that good. <span class="text-muted">See for
					yourself.</span>
			</h2>
			<p class="lead">Donec ullamcorper nulla non metus auctor
				fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur. Fusce
				dapibus, tellus ac cursus commodo.</p>
		</div>
		<div class="col-md-5 order-md-1">
			<img
				class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
				width="500" height="500" src="/resources/img/main.jpg" >
				<title>Placeholder</title><rect width="100%" height="100%"
					fill="#eee" />
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7">
			<h2 class="featurette-heading">
				And lastly, this one. <span class="text-muted">Checkmate.</span>
			</h2>
			<p class="lead">Donec ullamcorper nulla non metus auctor
				fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur. Fusce
				dapibus, tellus ac cursus commodo.</p>
		</div>
		<div class="col-md-5">
			<img
				class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
				width="500" height="500" src="/resources/img/main2.jpg" >
				<title>Placeholder</title><rect width="100%" height="100%"
					fill="#eee" />
		</div>
	</div>

	<hr class="featurette-divider">

	<!-- /END THE FEATURETTES -->

</div>
<!-- /.container -->
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>

