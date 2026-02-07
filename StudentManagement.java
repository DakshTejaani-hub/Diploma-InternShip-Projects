import java.io.*;

class StudentsDb {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // FileOutputStream fout = new FileOutputStream("a\\n");

    public static int studentCount = 0;
    String fName;
    String lName;
    int enrollmentNo;   
    int rollNo;
    String branch;

    static StudentsDb make_object() {
        studentCount++;
        return new StudentsDb();
    }

    void add_student(/* StudentsDb ob */) throws IOException {
        System.out.print("\nEnter Student's First Name: ");
        /* ob */this.fName = br.readLine();
        System.out.print("Enter Student's Last Name: ");
        /* ob */this.lName = br.readLine();
        System.out.print("Enter Student's Enrollment Number: ");
        /* ob */this.enrollmentNo = Integer.parseInt(br.readLine());
        System.out.print("Enter Student's Roll Number: ");
        /* ob */this.rollNo = Integer.parseInt(br.readLine());
        System.out.print("Enter Student's Branch: ");
        /* ob */this.branch = br.readLine();

        System.out.println("\n"/*  + studentCount*/);

        // return ob;
    }

    void update_student(StudentsDb arr[]) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int flag = 0;
        if(studentCount==0) {
            System.out.println("No Student In Records To Update!");
            return;
        }
        try {
            System.out.print("Enter Enrollment Number Of Student You Want to Update: ");
            int enroll = Integer.parseInt(br.readLine());
        
        
            for (int i = 0; i < StudentsDb.studentCount; i++) {
                if ((enroll) == (arr[i].enrollmentNo)) {
                    flag = 1;
                    System.out.println("\nEnter What to Update ");
                    System.out.println("1.First Name");
                    System.out.println("2.Last Name");
                    System.out.println("3.Roll Number");
                    System.out.println("4.Branch");
                    System.out.print("Enter Choice: ");
                    int tch = Integer.parseInt(br.readLine());

                    switch (tch) {
                        case 1:
                            System.out.print("Enter The New First Name: ");
                            arr[i].fName = br.readLine();
                            System.out.println("Updated First Name: " + arr[i].fName + "\n");
                            break;

                        case 2:
                            System.out.print("Enter The New Last Name:  ");
                            arr[i].lName = br.readLine();
                            System.out.println("Updated Last Name: " + arr[i].lName + "\n");
                            break;

                        case 3:
                            System.out.print("Enter New Roll No: ");
                            arr[i].rollNo = Integer.parseInt(br.readLine());
                            System.out.println("Updated Roll No: " + arr[i].rollNo + "\n");
                            break;

                        case 4:
                            System.out.print("Enter New Branch: ");
                            arr[i].branch = br.readLine();
                            System.out.println("Updated Branch: " + arr[i].branch + "\n");
                            break;

                        default:
                            System.out.println("Invalid Choice Entered!");
                            return;
                    }
                }
            }
        
            if (flag == 0)
                System.out.println("No Match Found For " + enroll + " Enrollment Number");
        }
        catch(NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    void search_student(StudentsDb arr[]) throws IOException {

        if(studentCount==0) {
            System.out.println("No Student In Records To Search!");
            return;
        }
        String tfName;
        String tlName;
        int tenrollmentNo;
        int trollNo;

        int flag = 0;

        System.out.println("\n1.Search By First Name");
        System.out.println("2.Search By Last Name");
        System.out.println("3.Search By Enrollment Number");
        System.out.println("4.Search By Roll No");
        System.out.print("Enter Choice: ");

        try {
            int tch = Integer.parseInt(br.readLine());

            switch (tch) {
                case 1:
                    System.out.print("\nEnter Name To Search: ");
                    tfName = br.readLine();
                    for (int i = 0; i < StudentsDb.studentCount; i++) {
                        if (tfName.equalsIgnoreCase(arr[i].fName)) {
                            flag = 1;
                            System.out.println("\nStudent Found,Here Are it's Details");

                            System.out.println("First Name: " + arr[i].fName);
                            System.out.println("Last Name: " + arr[i].lName);
                            System.out.println("Enrollment Number: " + arr[i].enrollmentNo);
                            System.out.println("Roll No: " + arr[i].rollNo);
                            System.out.println("Branch: " + arr[i].branch);
                        }
                    }
                    if (flag == 0)
                        System.out.println("Student Not Found!");
                break;

                case 2:
                    System.out.print("\nEnter Name To Search: ");
                    tlName = br.readLine();
                    for (int i = 0; i < StudentsDb.studentCount; i++) {
                        if (tlName.equalsIgnoreCase(arr[i].lName)) {
                            flag = 1;
                            System.out.println("\nStudent Found,Here Are it's Details");

                            System.out.println("First Name: " + arr[i].fName);
                            System.out.println("Last Name: " + arr[i].lName);
                            System.out.println("Enrollment Number: " + arr[i].enrollmentNo);
                            System.out.println("Roll No: " + arr[i].rollNo);
                            System.out.println("Branch: " + arr[i].branch);
                        }
                    }
                    if (flag == 0)
                        System.out.println("Student Not Found!");
                break;

                case 3:
                    System.out.print("\nEnter Enrollment Number To Search: ");
                    tenrollmentNo = Integer.parseInt(br.readLine());

                    for (int i = 0; i < StudentsDb.studentCount; i++) {
                        if (tenrollmentNo == (arr[i].enrollmentNo)) {
                            flag = 1;
                            System.out.println("\nStudent Found,Here Are it's Details");

                            System.out.println("First Name: " + arr[i].fName);
                            System.out.println("Last Name: " + arr[i].lName);
                            System.out.println("Enrollment Number: " + arr[i].enrollmentNo);
                            System.out.println("Roll No: " + arr[i].rollNo);
                            System.out.println("Branch: " + arr[i].branch);
                        }

                    }
                    if (flag == 0)
                        System.out.println("Student Not Found!");
                break;

                case 4:
                    System.out.print("\nEnter Roll Number To Search: ");
                    trollNo = Integer.parseInt(br.readLine());

                    for (int i = 0; i < StudentsDb.studentCount; i++) {
                        if (trollNo == arr[i].rollNo) {
                            flag = 1;
                            System.out.println("\nStudent Found,Here Are it's Details");

                            System.out.println("First Name: " + arr[i].fName);
                            System.out.println("Last Name: " + arr[i].lName);
                            System.out.println("Enrollment Number: " + arr[i].enrollmentNo);
                            System.out.println("Roll No: " + arr[i].rollNo);
                            System.out.println("Branch: " + arr[i].branch);
                        }
                    }
                    if (flag == 0)
                        System.out.println("Student Not Found!");
                break;

                default:
                    System.out.println("Invalid Choice Entered!");
                    return;
            }
        }
        catch(NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    void delete_student(StudentsDb arr[]) throws IOException {

        if(studentCount==0) {
            System.out.println("No Student In Records To Delete!");
            return;
        }
        int idx=0;
        int flag=0;
        int tenrollmentNo;
        try {
            System.out.print("Enter Enrollment Number Of Student You Want To Delete: ");
            tenrollmentNo = Integer.parseInt(br.readLine());
            for (int i = 0; i <StudentsDb.studentCount; i++) {
                if (tenrollmentNo == arr[i].enrollmentNo) {
                    flag=1;
                    idx = i;
                }
            }
            if(flag==1) {
                for (int i = idx; i < StudentsDb.studentCount-1; i++)
                    arr[i] = arr[i + 1];
                StudentsDb.studentCount--;
                System.out.println("\nStudent Deleted With Enrollment Number: " + tenrollmentNo);
            }
            else 
                System.out.println("Student With " + tenrollmentNo + " Enrollment Number Not Found");
        }
        catch(NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    void sort_sudents(StudentsDb arr[]) throws IOException {
        int tch;
        int ttch;

        if(studentCount==0) {
            System.out.println("No Student In Records To Sort!");
            return;
        }

        System.out.println("1.Sort By First Name");
        System.out.println("2.Sort By Last Name");
        System.out.println("3.Sort By Enrollment Number");
        System.out.println("4.Sort By Roll Number");
        System.out.println("5.Sort By Branch");
        System.out.print("\nEnter Choice: ");
        tch = Integer.parseInt(br.readLine() );

        switch(tch) {
            case 1:
                System.out.println("1.Ascending Order");
                System.out.println("2.Descending Order");
                System.out.print("\nEnter Choice: ");
                ttch = Integer.parseInt(br.readLine() );

                switch(ttch) {
                    case 1:
                        for(int i=0;i<StudentsDb.studentCount;i++) {
                            for(int j=i+1;j<StudentsDb.studentCount;j++) {

                                if(arr[i].fName.compareTo(arr[j].fName) > 0) {
                                    String tempStr = arr[i].fName;
                                    arr[i].fName = arr[j].fName;
                                    arr[j].fName = tempStr;

                                    String templName = arr[i].lName;
                                    arr[i].lName = arr[j].lName;
                                    arr[j].lName = templName;

                                    int tempEnrNo = arr[i].enrollmentNo;
                                    arr[i].enrollmentNo = arr[j].enrollmentNo;
                                    arr[j].enrollmentNo = tempEnrNo;

                                    int tempRollNo = arr[i].rollNo;
                                    arr[i].rollNo = arr[j].rollNo;
                                    arr[j].rollNo = tempRollNo;

                                    String tempBranch = arr[i].branch;
                                    arr[i].branch = arr[j].branch;
                                    arr[j].branch = tempBranch;
                                }
                            }
                        }

                    break;

                    case 2:
                        for(int i=0;i<StudentsDb.studentCount;i++) {
                            for(int j=i+1;j<StudentsDb.studentCount;j++) {

                                if(arr[i].fName.compareTo(arr[j].fName) < 0) {
                                    String tempStr = arr[i].fName;
                                    arr[i].fName = arr[j].fName;
                                    arr[j].fName = tempStr;

                                    String templName = arr[i].lName;
                                    arr[i].lName = arr[j].lName;
                                    arr[j].lName = templName;

                                    int tempEnrNo = arr[i].enrollmentNo;
                                    arr[i].enrollmentNo = arr[j].enrollmentNo;
                                    arr[j].enrollmentNo = tempEnrNo;

                                    int tempRollNo = arr[i].rollNo;
                                    arr[i].rollNo = arr[j].rollNo;
                                    arr[j].rollNo = tempRollNo;

                                    String tempBranch = arr[i].branch;
                                    arr[i].branch = arr[j].branch;
                                    arr[j].branch = tempBranch;
                                }
                            }
                        }

                    break;

                    default:
                        System.out.println("Invalid Coice!");
                }

            break;


            case 2://case 2 of sort by last name
                System.out.println("1.Ascending Order");
                System.out.println("2.Descending Order");
                System.out.print("\nEnter Choice: ");
                ttch = Integer.parseInt(br.readLine() );

                switch(ttch) {
                    case 1:
                        for(int i=0;i<StudentsDb.studentCount;i++) {
                            for(int j=i+1;j<StudentsDb.studentCount;j++) {

                                if(arr[i].lName.compareTo(arr[j].lName) > 0) {
                                    String tempStr = arr[i].lName;
                                    arr[i].lName = arr[j].lName;
                                    arr[j].lName = tempStr;

                                    String tempfName = arr[i].fName;
                                    arr[i].fName = arr[j].fName;
                                    arr[j].fName = tempfName;

                                    int tempEnrNo = arr[i].enrollmentNo;
                                    arr[i].enrollmentNo = arr[j].enrollmentNo;
                                    arr[j].enrollmentNo = tempEnrNo;

                                    int tempRollNo = arr[i].rollNo;
                                    arr[i].rollNo = arr[j].rollNo;
                                    arr[j].rollNo = tempRollNo;

                                    String tempBranch = arr[i].branch;
                                    arr[i].branch = arr[j].branch;
                                    arr[j].branch = tempBranch;
                                }
                            }
                        }

                    break;

                    case 2:
                        for(int i=0;i<StudentsDb.studentCount;i++) {
                            for(int j=i+1;j<StudentsDb.studentCount;j++) {

                                if(arr[i].lName.compareTo(arr[j].lName) < 0) {
                                    String templName = arr[i].lName;
                                    arr[i].lName = arr[j].lName;
                                    arr[j].lName = templName;

                                    String tempfName = arr[i].fName;
                                    arr[i].fName = arr[j].fName;
                                    arr[j].fName = tempfName;

                                    int tempEnrNo = arr[i].enrollmentNo;
                                    arr[i].enrollmentNo = arr[j].enrollmentNo;
                                    arr[j].enrollmentNo = tempEnrNo;

                                    int tempRollNo = arr[i].rollNo;
                                    arr[i].rollNo = arr[j].rollNo;
                                    arr[j].rollNo = tempRollNo;

                                    String tempBranch = arr[i].branch;
                                    arr[i].branch = arr[j].branch;
                                    arr[j].branch = tempBranch;

                                    
                                }
                            }
                        }

                    break;

                    default:
                        System.out.println("Invalid Coice!");
                }

            break;

            case 3: //case 3 of sort by enr no
                System.out.println("1.Ascending Order");
                System.out.println("2.Descending Order");
                System.out.print("\nEnter Choice: ");
                ttch = Integer.parseInt(br.readLine() );

                switch(ttch) {
                    case 1:
                        for(int i=0;i<StudentsDb.studentCount;i++) {
                            for(int j=i+1;j<StudentsDb.studentCount;j++) {
                                if(arr[i].enrollmentNo>arr[j].enrollmentNo) {

                                    int tempEnrNo = arr[i].enrollmentNo;
                                    arr[i].enrollmentNo = arr[j].enrollmentNo;
                                    arr[j].enrollmentNo = tempEnrNo;
                                    
                                    String templName = arr[i].lName;
                                    arr[i].lName = arr[j].lName;
                                    arr[j].lName = templName;

                                    String tempfName = arr[i].fName;
                                    arr[i].fName = arr[j].fName;
                                    arr[j].fName = tempfName;


                                    int tempRollNo = arr[i].rollNo;
                                    arr[i].rollNo = arr[j].rollNo;
                                    arr[j].rollNo = tempRollNo;

                                    String tempBranch = arr[i].branch;
                                    arr[i].branch = arr[j].branch;
                                    arr[j].branch = tempBranch;
                                }
                            }
                        }
                    break;

                    case 2:
                        for(int i=0;i<StudentsDb.studentCount;i++) {
                            for(int j=i+1;j<StudentsDb.studentCount;j++) {
                                if(arr[i].enrollmentNo<arr[j].enrollmentNo) {
                                    
                                    int tempEnrNo = arr[i].enrollmentNo;
                                    arr[i].enrollmentNo = arr[j].enrollmentNo;
                                    arr[j].enrollmentNo = tempEnrNo;
                                    
                                    String templName = arr[i].lName;
                                    arr[i].lName = arr[j].lName;
                                    arr[j].lName = templName;

                                    String tempfName = arr[i].fName;
                                    arr[i].fName = arr[j].fName;
                                    arr[j].fName = tempfName;


                                    int tempRollNo = arr[i].rollNo;
                                    arr[i].rollNo = arr[j].rollNo;
                                    arr[j].rollNo = tempRollNo;

                                    String tempBranch = arr[i].branch;
                                    arr[i].branch = arr[j].branch;
                                    arr[j].branch = tempBranch;
                                }
                            }
                        }

                    break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            break;

            case 4:
                System.out.println("1.Ascending Order");
                System.out.println("2.Descending Order");
                System.out.print("\nEnter Choice: ");
                ttch = Integer.parseInt(br.readLine() );

                switch(ttch) {
                    case 1:
                        for(int i=0;i<StudentsDb.studentCount;i++) {
                            for(int j=i+1;j<StudentsDb.studentCount;j++) {
                                if(arr[i].rollNo>arr[j].rollNo) {

                                    int tempEnrNo = arr[i].enrollmentNo;
                                    arr[i].enrollmentNo = arr[j].enrollmentNo;
                                    arr[j].enrollmentNo = tempEnrNo;
                                    
                                    String templName = arr[i].lName;
                                    arr[i].lName = arr[j].lName;
                                    arr[j].lName = templName;

                                    String tempfName = arr[i].fName;
                                    arr[i].fName = arr[j].fName;
                                    arr[j].fName = tempfName;


                                    int tempRollNo = arr[i].rollNo;
                                    arr[i].rollNo = arr[j].rollNo;
                                    arr[j].rollNo = tempRollNo;

                                    String tempBranch = arr[i].branch;
                                    arr[i].branch = arr[j].branch;
                                    arr[j].branch = tempBranch;
                                }
                            }
                        }
                    break;

                    case 2:
                        for(int i =0;i<StudentsDb.studentCount;i++) {
                            for(int j=i+1;j<StudentsDb.studentCount;j++) {
                                if(arr[i].rollNo<arr[j].rollNo) {
                                    
                                    int tempEnrNo = arr[i].enrollmentNo;
                                    arr[i].enrollmentNo = arr[j].enrollmentNo;
                                    arr[j].enrollmentNo = tempEnrNo;
                                    
                                    String templName = arr[i].lName;
                                    arr[i].lName = arr[j].lName;
                                    arr[j].lName = templName;

                                    String tempfName = arr[i].fName;
                                    arr[i].fName = arr[j].fName;
                                    arr[j].fName = tempfName;


                                    int tempRollNo = arr[i].rollNo;
                                    arr[i].rollNo = arr[j].rollNo;
                                    arr[j].rollNo = tempRollNo;

                                    String tempBranch = arr[i].branch;
                                    arr[i].branch = arr[j].branch;
                                    arr[j].branch = tempBranch;
                                }
                            }
                        }

                    break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            break;


            case 5: //switch of sort student branch
                System.out.println("1.Ascending Order");
                System.out.println("2.Descending Order");
                System.out.print("\nEnter Choice: ");
                ttch = Integer.parseInt(br.readLine() );

                switch(ttch) {
                    case 1:
                        for(int i =0;i<StudentsDb.studentCount;i++) {
                            for(int j=i+1;j<StudentsDb.studentCount;j++) {
                                if(arr[i].branch.compareTo(arr[j].branch) > 0) {

                                    String tempBranch = arr[i].branch;
                                    arr[i].branch = arr[j].branch;
                                    arr[j].branch = tempBranch;
                                    
                                    int tempEnrNo = arr[i].enrollmentNo;
                                    arr[i].enrollmentNo = arr[j].enrollmentNo;
                                    arr[j].enrollmentNo = tempEnrNo;
                                    
                                    String templName = arr[i].lName;
                                    arr[i].lName = arr[j].lName;
                                    arr[j].lName = templName;

                                    String tempfName = arr[i].fName;
                                    arr[i].fName = arr[j].fName;
                                    arr[j].fName = tempfName;


                                    int tempRollNo = arr[i].rollNo;
                                    arr[i].rollNo = arr[j].rollNo;
                                    arr[j].rollNo = tempRollNo;

                                }
                            }
                        } 

                    break;


                    case 2:
                        for(int i =0;i<StudentsDb.studentCount;i++) {
                            for(int j=i+1;j<StudentsDb.studentCount;j++) {
                                if(arr[i].branch.compareTo(arr[j].branch) < 0) {

                                    String tempBranch = arr[i].branch;
                                    arr[i].branch = arr[j].branch;
                                    arr[j].branch = tempBranch;
                                    
                                    int tempEnrNo = arr[i].enrollmentNo;
                                    arr[i].enrollmentNo = arr[j].enrollmentNo;
                                    arr[j].enrollmentNo = tempEnrNo;
                                    
                                    String templName = arr[i].lName;
                                    arr[i].lName = arr[j].lName;
                                    arr[j].lName = templName;

                                    String tempfName = arr[i].fName;
                                    arr[i].fName = arr[j].fName;
                                    arr[j].fName = tempfName;


                                    int tempRollNo = arr[i].rollNo;
                                    arr[i].rollNo = arr[j].rollNo;
                                    arr[j].rollNo = tempRollNo;

                                }
                            }
                        }

                    break;

                    default:
                    System.out.println("Invalid Choice!");
                }

            break;

            default:
                System.out.println("Invalid Choice");

        }

    }

    public String toString() {

        return "\n" +
                "First Name: " + fName + "\n" +
                "Last Name: " + lName + "\n" +
                "Enrollment Number: " + enrollmentNo + "\n" +
                "Roll No: " + rollNo + "\n" +
                "Branch: " + branch + "\n";
    }

    void encryption() {
        
    }

    void decryption() {

    }

}

class StudentManagement {
    public static void main(String[] args) throws IOException {
        // FileOutputStream fout = new FileOutputStream("C:\\Users\\dtgam\\OneDrive\\Desktop\\java\\DbmsStudent\\Students");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ch;

        StudentsDb students[] = new StudentsDb[30];

        StudentsDb ref = new StudentsDb();


        try {
            while (true) {
                System.out.println("\n======M E N U======");
                System.out.println("1.Add Student");
                System.out.println("2.Update Student");
                System.out.println("3.Search Student");
                System.out.println("4.Delete Student");
                System.out.println("5.Display All Students");
                System.out.println("6.Sort Students");
                System.out.println("7.Exit");
                System.out.print("Enter Choice: ");
                ch = Integer.parseInt(br.readLine());

                switch (ch) {
                    case 1:
                        // StudentsDb s = StudentsDb.make_object();
                        ref = StudentsDb.make_object();
                        ref.add_student(/* s */);
                        students[StudentsDb.studentCount - 1] = ref;

                    break;

                    case 2:
                        ref.update_student(students);
                    break;

                    case 3:
                        ref.search_student(students);
                    break;

                    case 4:
                        ref.delete_student(students);
                    break;

                    case 5:
                        if(StudentsDb.studentCount==0)
                        System.out.println("No Student In Records To Display!");
                        for (int i = 0; i < StudentsDb.studentCount; i++)
                            System.out.println(students[i]);
                    break;

                    case 6:
                        ref.sort_sudents(students);

                    break;

                    case 7:
                        // String line;
                        // for (int i = 0; i < StudentsDb.studentCount; i++) {
                        //     line = students[i].fName;
                        // }
                        System.exit(0);
                    break;

                    default :
                        System.out.println("Invalid Choice Entered");
                }
            }
        }
        catch(NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
}