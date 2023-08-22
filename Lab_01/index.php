<?php
if(isset($_REQUEST['submit'])){
    $xml = new DOMDocument("1.0", "UTF-8");
    $xml->load("appointment_details.xml");
    $rootTag = $xml->getElementsByTagName("root")->item(0);
    $dataTag = $xml->createElement("data");
    $nameTag = $xml->createElement("name", $_REQUEST['name']);
    $dateTag = $xml->createElement("date", $_REQUEST['date']);
    $timeTag = $xml->createElement("time", $_REQUEST['time']);
    $emailTag = $xml->createElement("email", $_REQUEST['email']);
    
    $dataTag->appendChild($nameTag);
    $dataTag->appendChild($dateTag);
    $dataTag->appendChild($timeTag);
    $dataTag->appendChild($emailTag);

    $rootTag->appendChild($dataTag);

    $xml->save("appointment_details.xml");
    }
?>