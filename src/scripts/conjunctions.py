subordinating_conjunctions = ["unless", "after", "although", "as", "as if", "as long as", "as much as",
"as soon as", "as though", "because", "before", "by the time", "even if", "even though", "if", "in order that",
"in case", "in the event that", "lest", "now that", "once", "only", "only if", "provided that", "since", "so", 
"supposing", "that", "than", "though", "till", "until", "when", "whenever", "where", "whereas", "wherever", "whether or not", "while"]

def restart_option():
    print("\nWanna restart the application? (y/n)")
    restart_application = input("\nEnter your choice: ")
    if(restart_application == "y"):
        welcome_message()
    elif(restart_application == "n"):
        exit()
    else:
        ("Invalid option! Only select (y/n) to restart or exit the game!")
        restart_option()

def welcome_message():
    print("\nHello, this is a tool to check for coordinating conjunctions and other stuff that are important for commas.")
    option = input("\nEnter your choice: ")
    if option in subordinating_conjunctions:
        print("\nThe word " + option + " is a subordinate conjunction.")
        restart_option()

    elif option not in subordinating_conjunctions:
        digit = False

        for x in option:
            if x.isdigit():
                print("\nInvalid option! Don't enter in numbers, only letters!")
                digit = True
                restart_option()

        if not digit:
            print("\nYour input " + option + " does not seem to be a subordinate conjunction.")
            restart_option()

if __name__ == '__main__':
    welcome_message()
