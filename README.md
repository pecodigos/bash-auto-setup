## BASH AUTO COMMAND LINE EXECUTE

I made this simple program so it can help me whenever I need to make a fresh linux install. I have a folder with a lot of bash commands I do in a fresh install.

For example: 
```bash
sudo apt update && sudo apt upgrade
sudo apt install picom
sudo apt install maim
```

...and so on.

## How to use it

- Compile the code (***AutoBash.java*** file) using `javac AutoBash.java` command inside **src** folder;
- Execute ***AutoBash.class*** file using `java AutoBash` command (you need to omit `.class` extension);
- After executing the program, it will prompt you for the path from where the file in located;
- For Linux users, usually the path will start with `/home/{YOUR_USERNAME_HERE}/` since `~` probably won't work in this case.

Feel free to use this program as you want, following its **LICENSE** requirements.
