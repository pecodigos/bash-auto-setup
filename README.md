## BASH AUTO COMMAND LINE EXECUTE

I made this simple program so it can help me whenever I need to make a fresh linux install. I have a file with a lot of bash commands I do in a fresh installation.

For example: 
```bash
sudo apt update && sudo apt upgrade
sudo apt install picom
sudo apt install maim
```

...and so on.

## How to use it

- Compile the code (`AutoBash.java` file) using `javac AutoBash.java` command inside **src** folder;
- Execute `AutoBash.class` file using `java AutoBash` command (you need to omit `.class` extension);
- After executing the program, and you press '**1**', you will be prompted for the path from where the file is located;
- For Linux users, usually the path will start with `/home/{YOUR_USERNAME_HERE}/` since `~` probably won't work in this case;
- Enter your sudo password if it's needed. You can also unblock your sudo using a sudo command outside the program (for example, using `sudo apt update` and entering your password before executing the program).
- If you did that or is not executing a sudo command, you can just press enter when it prompts you for the password.
