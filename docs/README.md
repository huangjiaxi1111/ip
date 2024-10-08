# Killua User Guide

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Commands](#commands)
    - [List all tasks](#list-all-tasks)
    - [Create a todo](#create-a-todo)
    - [Create a deadline](#create-a-deadline)
    - [Create an event](#create-an-event)
    - [Mark/unmark a task as done](#markunmark-a-task-as-done)
    - [Delete a task](#delete-a-task)
    - [Find tasks](#find-tasks)
    - [Exit the program](#exit-the-program)

<img src="Ui.png" alt="Product Screenshot" width="500">

## Introduction
Killua is a not-so-friendly task manager.\
Don't disturb him with trivial tasks.\
Or else he will add you on his hit list!

## Features
1. Add tasks(todo, deadline, event)
2. Mark tasks as done
3. Delete tasks
4. Find tasks by keyword or date
5. List all tasks
6. Auto-save tasks to disk
7. Load tasks from disk on startup

## Commands

### List all tasks
```
list/ls
```
Lists all tasks.

### Create a todo
```
todo <description>
```
Create a todo with string description.

### Create a deadline
```
deadline/ddl <description> /by <yyyy-mm-dd[ hh:mm]>
```
Create a deadline with description and due date (time is option).
#### Example
```
ddl hw1 /by 2024-10-02
```

### Create an event
```
event/eve <description> /from <yyyy-mm-dd[ hh:mm]> /to <yyyy-mm-dd[ hh:mm]>
```
Create an event with description and duration (time is optional).
#### Example
```
event CCA /from 2024-10-02 18:00 /to 2024-10-02 20:00
```

### Mark/unmark a task as done
```
mark/m <index>
```
```
unmark/um <index>
```
Mark or unmark a task with its index on the list (start with 1).
### Delete a task
```
delete/del <index>
```
Delete a task with its index on the list (start with 1).

### Find tasks
```
find <keyword>
```
```
on <yyyy-mm-dd>
```

Find tasks matching with keyword.\
List all tasks on a specific date.

### Exit the program
```
bye
```