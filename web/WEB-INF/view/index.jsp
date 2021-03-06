<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge" />
		<title>导航栏</title>
		<link href="https://cdn.bootcss.com/font-awesome/5.8.0/css/all.css" rel="stylesheet" />
		<style>
				* {
					margin: 0;
					padding: 0;
					font-family: 'montserrat', sans-serif;
					box-sizing: border-box;
				}
				.services-section {
					background: #333;
					background-size: cover;
					padding: 60px 0;
				}
				.inner-width {
					width: 100%;
					max-width: 1200px;
					margin: auto;
					padding: 0 20px;
					overflow: hidden;
				}
				.section-title {
					text-align: center;
					color: #ddd;
					text-transform: uppercase;
					font-size: 40px;
				}
				.border {
					width: 160px;
					height: 2px;
					background: #82ccdd;
					margin: 40px auto;
				}
				.services-container {
					display: flex;
					flex-wrap: wrap;
					justify-content: center;
				}
				.service-box {
					max-width: 33.33%;
					padding: 30px;
					text-align: center;
					color: #ddd;
					cursor: pointer;
				}
				.service-icon {
					display: inline-block;
					width: 70px;
					height: 70px;
					border: 3px solid #82ccdd;
					color: #82ccdd;
					transform: rotate(45deg);
					margin-bottom: 30px;
					margin-top: 15px;
					transition: 0.3s linear;
				}
				.service-icon i {
					line-height: 70px;
					transform: rotate(-45deg);
					font-size: 26px;
				}
				.service-box:hover .service-icon {
					background: #82ccdd;
					color: #ddd;
				}
				.service-title {
					font-size: 18px;
					text-transform: uppercase;
					margin-bottom: 10px;
				}
				.service-desc {
					font-size: 14px;
				}
				@media screen and (max-width: 960px) {
					.service-box {
						max-width: 45%;
					}
				}
				@media screen and (max-width: 768px) {
					.service-box {
						max-width: 50%;
					}
				}
				@media screen and (max-width: 480px) {
					.service-box {
						max-width: 100%;
					}
				}
			</style>
	</head>
	<body>
		<div class="services-section">
			<div class="inner-width">
				<h1 class="section-title">Service</h1>
				<div class="border"></div>
				<div class="services-container">
					
					<div class="service-box">
						<div class="service-icon">
							<i class="fas fa-brush"></i>
						</div>
						<div class="service-title">班级管理</div>
						
					</div>
					<div class="service-box">
						<div class="service-icon">
							<i class="fas fa-object-ungroup"></i>
						</div>
						<div class="service-title">课表查询</div>
						
					</div>
					<div class="service-box">
						<div class="service-icon">
							<i class="fas fa-paint-brush"></i>
						</div>
						<div class="service-title">课表管理</div>
						
					</div>
					<div class="service-box">
						<div class="service-icon">
							<i class="fas fa-database"></i>
						</div>
						<div class="service-title">失物招领</div>
						
					</div>
					<div class="service-box">
						<div class="service-icon">
							<i class="fab fa-android"></i>
						</div>
						<div class="service-title">关于</div>
						
					</div>
				</div>
			</div>
		</div>
	</body>
</html>