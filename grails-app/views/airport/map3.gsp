<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
    </style>
    <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCrjR2di-VkMVBbObE_DvoHoibojn5ZY8s&sensor=false">
    </script>
    <script type="text/javascript">
      function initialize() {
    	var usCenterPoint = new google.maps.LatLng(39.833333, -98.583333)
        var mapOptions = {
          center: usCenterPoint,
          zoom: 4,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);

		<g:each in="${airportList}" status="i" var="airport">
			var point${airport.id} = new google.maps.LatLng(${airport.lat}, ${airport.lng});
      		var marker${airport.id} = new google.maps.Marker({
                position: point${airport.id},
                map: map,
                title: "${airport.name}"
            });
            var info${airport.id} = new google.maps.InfoWindow({
                content: "${airport.iata}<br>${airport.name}"
            });
        	google.maps.event.addListener(marker${airport.id}, 'click', function() {
        		info${airport.id}.open(map, marker${airport.id});
        	});
		</g:each>
      }
    </script>
  </head>
  <body onload="initialize()">
    <div id="map_canvas" style="width: 800px; height: 400px"></div>
  </body>
</html>