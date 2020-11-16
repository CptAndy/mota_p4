import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class App {

    public static void main(String[] args) {

        String fileName = "";
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);

        int choice = 0;
        do try {
            {
                System.out.println("---Main Menu---\n" +
                        "\n" +
                        "\n" +
                        "1) create a new list\n" +
                        "2) load an existing list\n" +
                        "3) quit");
                System.out.println("Enter a choice...: ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        createAFileMenu();

                        break;
                    case 2:
                        loadAFileMenu();
                        break;
                    case 3:
                        System.out.println("Good bye");
                        exit(0);
                        break;
                    default:
                        System.out.println("Choose the given options");
                        break;

                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Please Enter Integers only");
            input.nextLine();
        } while (choice != 3);
    }

    private static void loadAFileMenu() {
        Scanner input = new Scanner(System.in);
        // If the user hits yes they will be asked for a name for the file
        // If the file exists asks for a new file name
        // if the user hits no they will be taken back to the menu
        int fileChoice = 0;

        do try {
            {

                System.out.println("Would you like to load a List?" + "\n" +
                        "1.Yes" + "\n" + "2.No");
                fileChoice = input.nextInt();
                switch (fileChoice) {
                    case 1:
                        //asks for file name
                        //if the file exists asks again
                        //if the file name does not exist go to a submenu
                        ;
                        submenu(loadList());
                        break;
                    case 2:
                        menu();
                        break;
                    default:
                        System.out.println("Choose the given options");
                }

            }
        } catch (InputMismatchException ex) {
            System.out.println("Please enter an Integer");
            input.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found returning to menu...");
            menu();
        } catch (IOException e) {
            e.printStackTrace();
        } while (fileChoice != 2);

    }

    private static void createAFileMenu() {
        Scanner input = new Scanner(System.in);
        // If the user hits yes they will be asked for a name for the file
        // If the file exists asks for a new file name
        // if the user hits no they will be taken back to the menu
        int fileChoice = 0;

        do try {
            {

                System.out.println("Would you like to create a List?" + "\n" +
                        "1.Yes" + "\n" + "2.No");
                fileChoice = input.nextInt();
                switch (fileChoice) {
                    case 1:
                        //asks for file name
                        //if the file exists asks again
                        //if the file name does not exist go to a submenu
                        ;
                        submenu(createList());
                        break;
                    case 2:
                        menu();
                        break;
                    default:
                        System.out.println("Choose the given options");
                }

            }
        } catch (InputMismatchException ex) {
            System.out.println("Please enter an Integer");
            input.nextLine();
        } while (fileChoice != 2);

    }

    private static String createList() {


        Scanner listNameChoice = new Scanner(System.in);
        String listName = "";
        TaskList list = new TaskList();

        // get the name
        // if the name is empty or if it exists
        // Ask for a name till its valid
        // Once name is valid go to a sub menu
        while (true) {
            System.out.println("Enter a name for your list...: ");
            listName = listNameChoice.nextLine();

            if (!listName.trim().isEmpty() || !listName.isBlank() || listName.length() > 0) {
                File f = new File(listName + ".txt");

// if the file name exists ask the user to try entering a valid name...
                // if the user file exists send him back to menu...

                break;
            }
        }

        return listName;
    }

    private static String loadList() throws IOException {
        Scanner loadListNameChoice = new Scanner(System.in);
        String loadList = "";

        TaskList tl = new TaskList();
        ArrayList<TaskItem> ti = new ArrayList<>();
//get the name
        //if the name exists
        //Load it
        //go to submenu
        while (true) {
            System.out.println("Invalid file name will take you back to menu.");
            System.out.println("Enter the name of the file you would like to load...:");

            loadList = loadListNameChoice.nextLine();

            if (!loadList.trim().isEmpty() || !loadList.isBlank() || loadList.length() > 0) {


                BufferedReader abc = new BufferedReader(new FileReader(loadList));
                String s;

                try {
                    while ((s = abc.readLine()) != null) {
                        String[] elements = s.split(",");

                        tl.newAdd(new TaskItem(elements[0],elements[1],elements[2],Boolean.parseBoolean(elements[3])));

                    }

                    abc.close();
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("There seems to be an issue reading the file!");
                    System.out.println("Returning to menu...");
                    menu();
                }



            }

        }

        return loadList;
    }

    private static void submenu(String fileName) {

        TaskList list = new TaskList();
        int fileChoice = 0;
        Scanner input = new Scanner(System.in);
//Create a file?

        // If yes get file name
        //store in filename
        //go to submenu
        // Load a file?
        //if yes enter file to load
        //store in file name go to sub menu
        int subChoice = 0;
        do try {

            {

                System.out.println("List Operation Menu\n" +
                        "---------\n" +
                        "\n" +
                        "1) view the list\n" +
                        "2) add an item\n" +
                        "3) edit an item\n" +
                        "4) remove an item\n" +
                        "5) mark an item as completed\n" +
                        "6) unmark an item as completed\n" +
                        "7) save the current list\n" +
                        "8) quit to the main menu");
                System.out.println("Enter a choice...");
                subChoice = input.nextInt();

                switch (subChoice) {

                    case 1:
                        list.print();
                        break;
                    case 2:
                        TaskItem task = new TaskItem(getTaskName(), getTaskDescription(), getTaskDueDate(), false); // Automatically set to incomplete
                        list.newAdd(task);
                        // back to submenu
                        break;
                    case 3:
                        int updateChoice = 0;

                        try {
                            if (list.getSize() > 0) {
                                while (updateChoice != 4) {
                                    System.out.println("--- Editing Tasks Menu---");
                                    System.out.println(" ");
                                    System.out.println("What would you like to edit?");
                                    System.out.println("1. Task name");
                                    System.out.println("2. Description");
                                    System.out.println("3. Due date");
                                    System.out.println("4. Exit back to sub menu");
                                    updateChoice = input.nextInt();

                                    if (updateChoice == 1) {
                                        list.updateTitle(getIndex(), getTaskName());
                                    } else if (updateChoice == 2) {
                                        list.updateDescription(getIndex(), getTaskDescription());
                                    } else if (updateChoice == 3) {
                                        list.updateDuedate(getIndex(), getTaskDueDate());
                                    } else if (updateChoice == 4) {
                                        System.out.println("Returning to sub menu...");
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Add a task Item to begin editing....");
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid index");
                        }
                        // back to sub menu
                        break;
                    case 4:

                        int deleteChoice = 0;

                        try {
                            if (list.getSize() > 0) {
                                while (deleteChoice != 4) {
                                    System.out.println("--- Delete Task Menu---");
                                    System.out.println(" ");
                                    System.out.println("Delete a task?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");

                                    deleteChoice = input.nextInt();

                                    if (deleteChoice == 1) {
                                        list.deleteTask(getIndex());
                                    } else if (deleteChoice == 2) {
                                        System.out.println("Returning to sub menu...");
                                        break;

                                    }
                                }
                            } else {
                                System.out.println("Need at least 1 task to delete....");
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid index");
                        }
                        // yes or no
                        // if yes ask for index
                        // getIndex();
                        //delete a whole task index PERIODT
                        // back to sub menu
                        // if no
                        // back to sub menu
                        break;
                    case 5:
                        int markChoice = 0;

                        try {
                            if (list.getSize() > 0) {
                                while (markChoice != 4) {
                                    System.out.println("--- Mark as Complete---");
                                    System.out.println(" ");
                                    System.out.println("Complete a task?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");

                                    markChoice = input.nextInt();

                                    if (markChoice == 1) {
                                        list.setComplete(true, getIndex());

                                    } else if (markChoice == 2) {

                                        System.out.println("Returning to sub menu...");
                                        break;

                                    }
                                }
                            } else {
                                System.out.println("Need at least 1 task to delete....");
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid index");
                        }
                        // Would you like to mark a task?
                        // yes or no
                        // if yes ask for index
                        // get index
                        // mark as complete
                        break;
                    case 6:
                        int unmarkChoice = 0;

                        try {
                            if (list.getSize() > 0) {
                                while (unmarkChoice != 4) {
                                    System.out.println("--- Mark as Incomplete---");
                                    System.out.println(" ");
                                    System.out.println("Unmark a task?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");

                                    unmarkChoice = input.nextInt();

                                    if (unmarkChoice == 1) {
                                        list.setComplete(false, getIndex());
                                    } else if (unmarkChoice == 2) {
                                        System.out.println("Returning to sub menu...");
                                        break;

                                    }
                                }
                            } else {
                                System.out.println("Need at least 1 task to delete....");
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid index");
                        }
                        break;
                    case 7:
                        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
                        for (TaskItem t : list.taskList
                        ) {
                            out.write(t.toString());
                        }
                        out.close();
                        System.out.println("File created successfully");
                        break;
                    case 8:
                        // I think at the end of the day Ke$ha is a strong person.
                        // Also Zoey101 did not age well.
                        // Also Tori was untalented and tried to be problematic in Victorious
                        // I think the addition of pendulum monsters in yugioh was too much and the fact that they banned cards every other week is disgusting
                        // Digimon held more meaning than pokemon, but at the end of the day pokemon had better episodes when it revolved around legendary pokemon
                        // I Lost my sanity doing this project
                        menu();
                        // back to menu
                        break;
                    default:
                        System.out.println("Choose the given options");
                        break;

                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Integers only");
            input.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        } while (subChoice != 8);

    }

    public static int getIndex() {
        Scanner indexInput = new Scanner(System.in);
        int index = 0;
        System.out.println("Which index....?");
        index = indexInput.nextInt();
        return index;

    }

    private static String getTaskDueDate() {
        Scanner taskDueDateInput = new Scanner(System.in);
        String taskDueDate = "";


        while (true) {

            System.out.println("xxxx-xx-xx");
            System.out.println("Year/Month/day");
            System.out.println("Enter a Duedate...: ");
            taskDueDate = taskDueDateInput.nextLine();
            Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}"); // follows the format xxxx/xx/xx
            Matcher matcher = pattern.matcher(taskDueDate);
            if (!taskDueDate.isEmpty() && !taskDueDate.isBlank() && matcher.matches()) {
                break;
            }
        }

        return taskDueDate;

    }

    private static String getTaskDescription() {
        Scanner taskDescriptionInput = new Scanner(System.in);
        String taskDescription = "";
        while (true) {
            System.out.println("Enter a Description...: ");
            taskDescription = taskDescriptionInput.nextLine();
            if (!taskDescription.isEmpty() || !taskDescription.isBlank() || taskDescription.length() > 0) {
                break;
            }
        }
        return taskDescription;
    }

    private static String getTaskName() {
        Scanner taskNameInput = new Scanner(System.in);
        String taskName = "";
        while (true) {
            System.out.println("Enter a name for this task...: ");
            taskName = taskNameInput.nextLine();
            if (!taskName.isEmpty() || !taskName.isBlank()) {
                break;
            }
        }
        return taskName;
    }

}

