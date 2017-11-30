<!DOCTYPE html>
<html lang="pt_BR">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Open BDT | Report</title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- bootstrap-progressbar -->
    <link href="../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
    <link href="../build/css/main.css" rel="stylesheet">
    <script src="../build/js/Chart.bundle.js"></script>
    <script src="../build/js/utils.js"></script>
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view" style="width: 100%;">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><span>Open BDT | Report</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Bem-vindo</span>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>Geral</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="index.html">&Uacute;ltima Execu&ccedil;&atilde;o</a></li>
                    </ul>
                  </li>
                    <ul class="nav child_menu">
                      <li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
                      <li><a href="fixed_footer.html">Fixed Footer</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">

            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- page content -->
        <div class="right_col" role="main">
          <!-- top tiles -->
          <div class="row tile_count">
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-user"></i> Pendente</span>
              <div class="count orange_bdt">${count_pending}</div>
              <canvas height="36" width="36" id="partly-cloudy-day" class="icon-canvas"></canvas>
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-clock-o"></i> Erro</span>
              <div class="count red">${count_error}</div>
              <canvas height="36" width="36" id="rain" class="icon-canvas"></canvas>
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-user"></i> Sucesso</span>
              <div class="count green">${count_success}</div>
              <canvas height="36" width="36" id="clear-day" class="icon-canvas"></canvas>
            </div>
            <div id="count_ignored" class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-user"></i> Ignorado</span>
              <div class="count blue_bdt">${count_ignored}</div>
              <canvas height="36" width="36" id="wind" class="icon-canvas"></canvas>
            </div>
            <div id="img-logo" class="col-md-2 col-sm-4 col-xs-6">
                <img src="images/open_bdt_logo.png" alt="Open BDT">
            </div>
          </div>
          <!-- /top tiles -->
          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="dashboard_graph">
                <div class="row x_title">
                  <div class="col-md-6">
                    <h3>Estat&iacute;ticas da execu&ccedil;&atilde;o</h3>
                  </div>
                </div>
                <div id="container_chart" class="col-md-9 col-sm-9 col-xs-12">
                  <div class="container-test"></div>
                </div>
                 <div id="chart_doughnut" class="col-md-3 col-sm-3 col-xs-12 bg-white">
                     <div class="x_panel tile fixed_height_320 overflow_hidden">
                     <div class="x_title">
                       <h2>Resultados</h2>
                       <div class="clearfix"></div>
                     </div>
                     <div class="x_content">
                       <table class="" style="width:100%">
                         <tr>
                           <th style="width:37%;">
                             <p>Gr&aacute;fico</p>
                           </th>
                           <th>
                             <div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
                               <p>Status</p>
                             </div>
                           </th>
                         </tr>
                         <tr>
                           <td>
                             <canvas class="canvasDoughnut" height="180" width="180" style="margin: 15px 10px 10px 0"></canvas>
                           </td>
                           <td>
                             <table class="tile_info">
                               <tr>
                                 <td>
                                   <p><i class="fa fa-square orange_bdt"></i>Pendente </p>
                                 </td>
                               </tr>
                               <tr>
                                 <td>
                                   <p><i class="fa fa-square red"></i>Erro </p>
                                 </td>
                               </tr>
                               <tr>
                                 <td>
                                   <p><i class="fa fa-square  green"></i>Sucesso </p>
                                 </td>
                               </tr>
                               <tr>
                               <tr>
                                 <td>
                                   <p><i class="fa fa-square blue"></i>Ignorado </p>
                                 </td>
                               </tr>
                             </table>
                           </td>
                         </tr>
                       </table>
                     </div>
                   </div>
                </div>
                <div class="clearfix"></div>
              </div>
            </div>

          </div>
          <br />

        <div class="row">
            <div class="row top_tiles">
                <#list scenario_div as div>
                    ${div}
                </#list>
                </div>
              </div>
              </div>
              </div>
              </div>
            </div>
          </div>
        </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Open BDT | Report - <a target="blank" href="#">Open BDT</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="../vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="../vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="../vendors/Flot/jquery.flot.js"></script>
    <script src="../vendors/Flot/jquery.flot.pie.js"></script>
    <script src="../vendors/Flot/jquery.flot.time.js"></script>
    <script src="../vendors/Flot/jquery.flot.stack.js"></script>
    <script src="../vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="../vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="../vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="../vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="../vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>

    <script>
    function createConfig(details, data) {
     return {
         type: 'line',
         data: {
             labels: ['Pendente', 'Erro', 'Sucesso', 'Ignorado'],
             datasets: [{
                 label: '\xDAltimas ' + ((typeof(details.steppedLine) === 'boolean') ? details.steppedLine : ``),
                 steppedLine: details.steppedLine,
                 data: data,
                 borderColor: details.color,
                 fill: false,
             }]
         },
         options: {
             responsive: true,
             title: {
                 display: true,
                 text: details.label,
             }
         }
     };
 }

 window.onload = function() {

     init_chart_doughnut();

     var container = document.querySelector('.container-test');

     var data = [
         ${count_pending},
         ${count_error},
         ${count_success},
         ${count_ignored}
     ];

     var steppedLineSettings = [{
         steppedLine: 'Executadas',
         label: '\xDAltima Execu\xE7\xE3o',
         color: window.chartColors.green
     }];

     steppedLineSettings.forEach(function(details) {
         var div = document.createElement('div');
         div.classList.add('chart-container');

         var canvas = document.createElement('canvas');
         div.appendChild(canvas);
         container.appendChild(div);

         var ctx = canvas.getContext('2d');
         var config = createConfig(details, data);
         new Chart(ctx, config);
        });
    };

function init_chart_doughnut(){

		if( typeof (Chart) === 'undefined'){ return; }

		console.log('init_chart_doughnut');

		if ($('.canvasDoughnut').length){

		var chart_doughnut_settings = {
				type: 'doughnut',
				tooltipFillColor: "rgba(51, 51, 51, 0.55)",
				data: {
					labels: [
						"Pendente",
						"Erro",
						"Sucesso",
						"Ignorado"
					],
					datasets: [{
						data: [${count_pending}, ${count_error}, ${count_success}, ${count_ignored}],
						backgroundColor: [
							"#FFA500",
							"#E74C3C",
							"#26B99A",
							"#12ACCD"
						],
						hoverBackgroundColor: [
							"#FFC04C",
                            "#E95E4F",
                            "#36CAAB",
							"#41BCD7"
						]
					}]
				},
				options: {
					legend: false,
					responsive: false
				}
			}

			$('.canvasDoughnut').each(function(){

				var chart_element = $(this);
				var chart_doughnut = new Chart( chart_element, chart_doughnut_settings);

			});
		}
	}
   </script>
  </body>
</html>
