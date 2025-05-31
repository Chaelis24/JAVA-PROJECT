<?php
include "db_connection.php";

$programs = [];
$progResult = mysqli_query($conn, "SELECT program_id, program_name FROM tbl_program");
while ($row = mysqli_fetch_assoc($progResult)) {
    $programs[] = $row;
}

$courseCounts = [];
foreach ($programs as $program) {
    $countQuery = "SELECT COUNT(student_id) FROM tbl_student WHERE program_id = " . $program['program_id'];
    $countResult = mysqli_query($conn, $countQuery);
    $countRow = mysqli_fetch_row($countResult);
    $courseCounts[] = [
        'program_name' => $program['program_name'],
        'count' => $countRow[0]
    ];
}

$totalQuery = mysqli_query($conn, "SELECT COUNT(student_id) FROM tbl_student");
$totalRow = mysqli_fetch_row($totalQuery);
$totalStudents = $totalRow[0];

$yearCounts = [];
$schoolYearResult = mysqli_query($conn, "SELECT school_year_id, year_label FROM tbl_school_year");
while ($row = mysqli_fetch_assoc($schoolYearResult)) {
    $yearId = $row['school_year_id'];
    $yearLabel = $row['year_label'];

    $countQuery = "SELECT COUNT(student_id) FROM tbl_student WHERE school_year_id = $yearId";
    $countResult = mysqli_query($conn, $countQuery);
    $countRow = mysqli_fetch_row($countResult);

    $yearCounts[$yearLabel] = $countRow[0];
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Student Information System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>
    <div class="offcanvas offcanvas-start d-md-none bg-dark text-white" tabindex="-1" id="sidebar" aria-labelledby="sidebarLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="sidebarLabel">Menu</h5>
            <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <div class="text-center mb-4">
                <img src="img/bg-removed.png" alt="Logo" class="img-circle img-fluid" />
            </div>
            <ul class="nav flex-column sidebar">
                <li class="nav-item py-1"><a href="index.php" class="nav-link text-white active"><i class="bi bi-house-door-fill me-1"></i> Home</a></li>
                <li class="nav-item py-1"><a href="add_student.php" class="nav-link text-white"><i class="bi bi-plus-circle-fill me-1"></i> Add Student</a></li>
                <li class="nav-item py-1"><a href="retrieve_student.php" class="nav-link text-white"><i class="bi bi-person-lines-fill me-1"></i> View Students</a></li>
                <li class="nav-item py-1"><a href="#" class="nav-link text-white"><i class="bi bi-question-circle-fill me-1"></i> FAQ</a></li>
                <li class="nav-item py-3"><a href="#" class="nav-link text-white text-center"><i class="bi bi-box-arrow-right me-1"></i> Log Out</a></li>
            </ul>
        </div>
    </div>

    <div class="container-fluid px-0">
        <div class="row g-0">
            <nav class="d-none d-md-flex col-md-3 col-lg-2 bg-dark text-white flex-column p-3" style="min-height: 100vh;">
                <div class="text-center mb-4">
                    <img src="img/bg-removed.png" alt="Logo" class="img-circle img-fluid" />
                </div>
                <ul class="nav flex-column sidebar">
                    <li class="nav-item py-1"><a href="index.php" class="nav-link text-white active"><i class="bi bi-house-door-fill me-1"></i> Home</a></li>
                    <li class="nav-item py-1"><a href="add_student.php" class="nav-link text-white"><i class="bi bi-plus-circle-fill me-1"></i> Add Student</a></li>
                    <li class="nav-item py-1"><a href="retrieve_student.php" class="nav-link text-white"><i class="bi bi-person-lines-fill me-1"></i> View Students</a></li>
                    <li class="nav-item py-1"><a href="#" class="nav-link text-white"><i class="bi bi-question-circle-fill me-1"></i> FAQ</a></li>
                </ul>
                <div class="mt-auto pt-3">
                    <a href="#" class="nav-link text-white text-center"><i class="bi bi-box-arrow-right me-1"></i> Log Out</a>
                </div>
            </nav>

            <main class="col-md-9 col-lg-10">
                <header class="d-flex justify-content-between align-items-center p-3" style="background-color: #108500;">
                    <div class="d-flex align-items-center text-white">
                        <button class="btn btn-light d-md-none me-3" type="button" data-bs-toggle="offcanvas" data-bs-target="#sidebar" aria-controls="sidebar">
                            <i class="bi bi-list"></i>
                        </button>
                        <div>
                            <h5 class="mb-0">Top Link Global College, Inc.</h5>
                            <small>Liwag Building, Cabanatuan City, Nueva Ecija</small>
                        </div>
                    </div>
                    <div class="d-flex align-items-center" style="font-size: 0.85rem;">
                        <img src="img/admin.png" alt="Admin" class="img-circle-sm img-fluid" style="width:30px; height:30px; object-fit:cover;" />
                        <span class="text-white fw-bold ms-2">Admin</span>
                    </div>
                </header>

                <div class="container py-4">
                    <h1 class="text-white text-center">Courses and Blocks</h1>
                    <div class="row justify-content-center g-3">
                        <?php foreach ($courseCounts as $course): ?>
                            <div class="col-6 col-md-4 col-lg-3">
                                <div class="card text-white text-center shadow" style="background-color: #108500;">
                                    <div class="card-body">
                                        <h5 class="card-title"><?= htmlspecialchars($course['program_name']) ?></h5>
                                        <p class="card-text"><?= $course['count'] ?></p>
                                    </div>
                                </div>
                            </div>
                        <?php endforeach; ?>
                    </div>

                    <div class="row justify-content-center mb-4 mt-4">
                        <div class="col-12 col-md-10 col-lg-8">
                            <div class="card text-white shadow" style="background-color: #108500;">
                                <div class="card-header bg-white text-black text-center">
                                    <h5 class="mb-0" style="color: #108500;">Total Number of Enrollees per S.Y.</h5>
                                </div>
                                <div class="card-body text-white">
                                    <table class="table table-bordered text-center table-greens" style="background-color: #108500; border-color: #108500;">
                                        <thead class="text-white" style="background-color: #0e7800;">
                                            <tr>
                                                <th>S.Y. 2023-2024</th>
                                                <th>S.Y. 2024-2025</th>
                                                <th>S.Y. 2025-2026</th>
                                                <th>Total Students</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="background-color: #108500;"><?= $yearCounts['2023-2024'] ?? 0 ?></td>
                                                <td style="background-color: #108500;"><?= $yearCounts['2024-2025'] ?? 0 ?></td>
                                                <td style="background-color: #108500;"><?= $yearCounts['2025-2026'] ?? 0 ?></td>
                                                <td style="background-color: #0e7800; font-weight: bold;"><?= $totalStudents ?></td>
                                            </tr>
                                        </tbody>
                                    </table>    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>