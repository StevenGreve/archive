import sys, time
from random import choice, randint 

def print_credits():
    print("\n+------------------------------------+")
    print("|            Created by              |")
    print("|        Steven Bryan Greve          |")
    print("+------------------------------------+")

def print_slow(str):
    for letter in str:
        sys.stdout.write(letter)
        sys.stdout.flush()
        time.sleep(0.1)

def main_menu():
    print("+------------------------------------------+")
    print("|                MAIN MENU                 |")
    print("+------------------------------------------+")
    print(44 * '-')
    print("{} Arcade Mode".format("[1]"))
    print("{} Story Mode".format("[2]"))
    print("{} Credits".format("[3]"))
    print("{} Exit".format("[4]"))
    print(44 * '-')

    while True:
        try:
            option = int(input("\nEnter your choice: "))
            if(option == 1):
                character_selection()
                break
            elif(option == 2):
                print("\nThis feature is not finished yet.")
                restart_game()
                break
            elif(option == 3):
                print_credits()
                restart_game()
                break
            elif(option == 4):
                print("\nThanks for playing!")
                break
            else:
                print("\nInvalid choice! Please enter a number between 1-4!")
        except ValueError:
            print("\nInvalid choice! Please enter a number between 1-4!")
    exit

def restart_game():
    print("\nWanna restart the game? (y/n)")
    restart_option = input("\nEnter your choice: ")
    if(restart_option == "y"):
        main_menu()
    elif(restart_option == "n"):
        print("\nThanks for playing!")
        exit()
    else:
        print("\nInvalid option! Select (y/n) to restart or exit the game!")
        restart_game()

class Character(object):
    def __init__(self, name, hp, low_attack, mid_attack, high_attack, score):
        self.name = name
        self.hp = hp
        self.max_hp = hp
        self.low_attack = low_attack
        self.mid_attack = mid_attack
        self.high_attack = high_attack
        self.score = 0
        

    def update_hp(self, new_value):
        temporary_hp = self.hp + new_value
        if(0 < temporary_hp and temporary_hp <= self.max_hp):
            self.hp = temporary_hp
        else:
           self.hp = 0
           #print(f"{self.name} lost")
           #quit()

def random_enemy():
    """Creates a new random opponent.
    
    Returns:
    [Character]: [populated with certain stats]
    """
    return Character(
        choice(["Kazuya Mishima", "Heihachi Mishima"]),
        170,
        randint(7, 33),
        randint(18, 42),
        randint(10, 25),
        0
    )  

kazuya_Mishima = Character("Kazuya Mishima", 170, randint(7, 33), randint(18, 30), 17, 0)
heihachi_Mishima = Character("Heihachi Mishima", 170, randint(11, 24), 35, randint(15, 30), 0)
enemy = random_enemy() 

def character_selection():
    print(44 * '-')
    print("+------------------------------------------+")
    print("|           CHARACTER SELECTION            |")
    print("+------------------------------------------+")
    print(44 * '-')
    print("{} Kazuya Mishima".format("[1]"))
    print("{} Heihachi Mishima".format("[2]"))
    print(44 * '-')
    option = int(input("\nEnter your choice: "))
    if(option == 1):
        kazuya_attack()
    elif(option == 2):
        heihachi_attack()
    else:
        print("\nInvalid choice! Please enter a number between 1-2!")

def kazuya_attack():
    print(44 * '-')
    print("+------------------------------------------+")
    print("|            H I G H S C O R E             |")
    print("+------------------------------------------+")
    print(44 * '-')
    print(11*" " + "You: ", kazuya_Mishima.score, 5*' ', "CPU: ", enemy.score)
    print(44 * '-')
    print("Your HP: ", kazuya_Mishima.hp, "\n\nCPU HP: ", enemy.hp)
    print("\nMovelist: ")
    print("\n{} Hellsweep".format("[1]"))
    print("{} Abolishing Fist".format("[2]"))
    print("{} Hell Lancer".format("[3]"))
    
    while(enemy.hp > 0 and kazuya_Mishima.hp > 0):
        option = int(input("\nEnter your choice: "))
        if(option == 1):
            enemy.update_hp(-kazuya_Mishima.low_attack)
            print("\nYour opponent", enemy.name, "got hit and has", enemy.hp, "HP left.")
            kazuya_Mishima.update_hp(-enemy.high_attack)
            print("You receive", enemy.high_attack, "damage in retaliation and have", kazuya_Mishima.hp, "HP left.")
        elif(option == 2):
            enemy.update_hp(-kazuya_Mishima.mid_attack)
            print("\nYour enemy", enemy.name, "got hit and has", enemy.hp, "HP left.")
            kazuya_Mishima.update_hp(-enemy.low_attack)
            print("You receive", enemy.low_attack, "damage in retaliation and are left with", kazuya_Mishima.hp, "HP.")            
        elif(option == 3):
            enemy.update_hp(-kazuya_Mishima.high_attack)
            print("\nA FIERCE blow! Your enemy", enemy.name, "takes", kazuya_Mishima.high_attack, "damage. Your opponent got", enemy.hp, "HP left.")
            kazuya_Mishima.update_hp(-enemy.mid_attack)
            print("You receive", enemy.mid_attack, "damage in retaliation. You now got", kazuya_Mishima.hp, "HP left.")

    if(kazuya_Mishima.hp == 0):
        enemy.score += 1
        if(enemy.score == 1):
            print("+------------------------------------------+")
            print("|                 YOU LOSE                 |")
            print("+------------------------------------------+")
            print(44 * '-')
            print(11*" " + "You: ", kazuya_Mishima.score, 5*' ', "CPU: ", enemy.score)
            print(44 * '-')
            kazuya_Mishima.hp = 170
            enemy.hp = 170
            next_round_kazuya()
        elif(enemy.score == 2):
            print("+------------------------------------------+")
            print("|                GAME OVER                 |")
            print("+------------------------------------------+")
            print(44 * '-')
            print(11*" " + "You: ", kazuya_Mishima.score, 5*' ', "CPU: ", enemy.score)
            print(44 * '-')
            kazuya_Mishima.hp = 170
            enemy.hp = 170
            enemy.score = 0
            kazuya_Mishima.score = 0
            restart_game()
    elif(enemy.hp == 0):
        kazuya_Mishima.score += 1
        if(kazuya_Mishima.score == 1):
            print("+------------------------------------------+")
            print("|                  YOU WIN                 |")
            print("+------------------------------------------+")
            print(44 * '-')
            print(11*" " + "You: ", kazuya_Mishima.score, 5*' ', "CPU: ", enemy.score)
            print(44 * '-')
            kazuya_Mishima.hp = 170
            enemy.hp = 170
            next_round_kazuya()
        elif(kazuya_Mishima.score == 2):
            print("+------------------------------------------+")
            print("|                  YOU WIN                 |")
            print("+------------------------------------------+")
            print(44 * '-')
            print(11*" " + "You: ", kazuya_Mishima.score, 5*' ', "CPU: ", enemy.score)
            print(44 * '-')
            kazuya_Mishima.hp = 170
            enemy.hp = 170
            enemy.score = 0
            kazuya_Mishima.score = 0
            restart_game()

def heihachi_attack():
    print(44 * '-')
    print("+------------------------------------------+")
    print("|            H I G H S C O R E             |")
    print("+------------------------------------------+")
    print(44 * '-')
    print(11*" " + "You: ", heihachi_Mishima.score, 5*' ', "CPU: ", enemy.score)
    print(44 * '-')
    print("Your HP: ", heihachi_Mishima.hp, "\n\nCPU HP: ", enemy.hp)
    print("\nMovelist: ")
    print("\n{} Jumping Low Kick".format("[1]"))
    print("{} Electric Wind God Fist".format("[2]"))
    print("{} Right Splits Kick".format("[3]"))

    while(enemy.hp > 0 and heihachi_Mishima.hp >0):
        option = int(input("\nEnter your choice: "))
        if(option == 1):
            enemy.update_hp(-heihachi_Mishima.low_attack)
            print("\nYour opponent", enemy.name, "got hit and has", enemy.hp, "HP left.")
            heihachi_Mishima.update_hp(-enemy.mid_attack)
            print("You receive", enemy.mid_attack, "damage in retaliation and have", heihachi_Mishima.hp, "HP left.")
        elif(option == 2):
            enemy.update_hp(-heihachi_Mishima.mid_attack)
            print("\nYour enemy", enemy.name, "got hit and has", enemy.hp, "HP left.")
            heihachi_Mishima.update_hp(-enemy.high_attack)
            print("You receive", enemy.high_attack, "damage in retaliation and are left with", heihachi_Mishima.hp, "HP.")            
        elif(option == 3):
            enemy.update_hp(-heihachi_Mishima.high_attack)
            print("\nA FIERCE blow! Your enemy", enemy.name, "takes", heihachi_Mishima.high_attack, "damage. Your opponent got", enemy.hp, "HP left.")
            heihachi_Mishima.update_hp(-enemy.low_attack)
            print("You receive", enemy.low_attack, "damage in retaliation. You now got", heihachi_Mishima.hp, "HP left.")

    if(heihachi_Mishima.hp == 0):
        enemy.score += 1
        if(enemy.score == 1):
            print("+------------------------------------------+")
            print("|                 YOU LOSE                 |")
            print("+------------------------------------------+")
            print(44 * '-')
            print(11*" " + "You: ", heihachi_Mishima.score, 5*' ', "CPU: ", enemy.score)
            print(44 * '-')
            heihachi_Mishima.hp = 170
            enemy.hp = 170
            next_round_heihachi()
        elif(enemy.score == 2):
            print("+------------------------------------------+")
            print("|                GAME OVER                 |")
            print("+------------------------------------------+")
            print(44 * '-')
            print(11*" " + "You: ", heihachi_Mishima.score, 5*' ', "CPU: ", enemy.score)
            print(44 * '-')
            heihachi_Mishima.hp = 170
            enemy.hp = 170
            enemy.score = 0
            heihachi_Mishima.score = 0
            restart_game()
    elif(enemy.hp == 0):
        heihachi_Mishima.score += 1
        if(heihachi_Mishima.score == 1):
            print("+------------------------------------------+")
            print("|                  YOU WIN                 |")
            print("+------------------------------------------+")
            print(44 * '-')
            print(11*" " + "You: ", heihachi_Mishima.score, 5*' ', "CPU: ", enemy.score)
            print(44 * '-')
            heihachi_Mishima.hp = 170
            enemy.hp = 170
            next_round_heihachi()
        elif(heihachi_Mishima.score == 2):
            print("+------------------------------------------+")
            print("|                  YOU WIN                 |")
            print("+------------------------------------------+")
            print(44 * '-')
            print(11*" " + "You: ", heihachi_Mishima.score, 5*' ', "CPU: ", enemy.score)
            print(44 * '-')
            heihachi_Mishima.hp = 170
            enemy.hp = 170
            enemy.score = 0
            heihachi_Mishima.score = 0
            restart_game()

def next_round_kazuya():
    print("\nAre you ready for the next battle? (y/n)")
    new_game = input("\nEnter your choice: ")
    if(new_game == "y"):
        kazuya_attack()
    elif(new_game == "n"):
        enemy.score = 0
        kazuya_Mishima.score = 0
        enemy.hp = 170
        kazuya_Mishima.hp = 170
        print("\nThanks for playing!")
        exit()
    else:
        print("\nInvalid option! Select (y/n) to play the next round or to exit the game!")
        next_round_kazuya()

def next_round_heihachi():
    print("\nAre you ready for the next battle? (y/n)")
    next_game = input("\nEnter your choice: ")
    if(next_game == "y"):
        heihachi_attack()
    elif(next_game == "n"):
        enemy.score = 0
        heihachi_Mishima.score = 0
        enemy.hp = 170
        heihachi_Mishima.hp = 170
        print("\nThanks for playing!")
        exit()
    else: 
        print("\nInvalid option! Select (y/n) to play the next round or to exit the game!")
        next_round_heihachi()

if __name__ == '__main__':
    print(44*'-')
    print_slow("Welcome to the King of Iron Fist Tournament!")
    print("\n" + 44*'-')
    main_menu()
    