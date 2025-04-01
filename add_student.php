<?php
$conn = new mysqli("localhost", "root", "#pucjl29yp", "student_db");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$name = $_POST['name'];
$roll_number = $_POST['roll_number'];
$class = $_POST['class'];

$sql = "INSERT INTO students (name, roll_number, class) VALUES ('$name', '$roll_number', '$class')";
if ($conn->query($sql) === TRUE) {
    echo "success";
} else {
    echo "error: " . $conn->error;
}

$conn->close();
?>