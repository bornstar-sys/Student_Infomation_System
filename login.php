<?php
$conn = new mysqli("localhost", "root", "#pucjl29yp", "student_db");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$username = $_POST['username'];
$password = $_POST['password'];
$role = $_POST['role'];

$sql = "SELECT * FROM users WHERE username='$username' AND password='$password' AND role='$role'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "success";
} else {
    echo "fail";
}

$conn->close();
?>