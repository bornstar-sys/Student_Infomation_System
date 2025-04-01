<?php
$conn = new mysqli("localhost", "root", "#pucjl29yp", "student_db");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$id = $_POST['id'];
$name = $_POST['name'];
$roll_number = $_POST['roll_number'];
$class = $_POST['class'];

$sql = "UPDATE students SET name='$name', roll_number='$roll_number', class='$class' WHERE id='$id'";
if ($conn->query($sql) === TRUE) {
    echo "success";
} else {
    echo "error: " . $conn->error;
}

$conn->close();
?>