class Writer:

    def beginPrompt(self):
        import os
        directory = os.getcwd()
        thing = ""
        while thing.find("/stop") == -1:
            thing += input('')

            if not thing.find("/write") == -1:
                self.beginWriting(directory)
                thing = self.elimString(thing, "/write")

            if not thing.find("/cd") == -1:
                print(directory)
                thing = self.elimString(thing, "/cd")

            if not thing.find("/cout") == -1:
                no = ""
                lastLoc = directory.rfind("/")
                while lastLoc < len(directory):
                    no += directory.__getitem__(lastLoc)
                directory = directory.replace(no, "")
                print(directory)
                thing = self.elimString(thing, "/cout")

            if not thing.find("/findfile") == -1:
                self.findFile(directory)
                thing = self.elimString(thing, "/findfile")

            if not thing.find("/list") == -1:
                import os
                list = os.listdir(directory)
                loc = 0;
                found = 0;


                while loc < len(list):
                    print(list.__getitem__(loc))
                    found += 1
                    loc += 1
                print("\n" + repr(found) + " files.")
            thing = self.elimString(thing, "/list")

            if not thing.find("/delete") == -1:
                self.deleteFile(directory)
                thing = self.elimString(thing, "/delete")





    def beginWriting(self, directory):
        text = ""
        while text.find("/close") == -1:
            text += input(' ')

        self.toFile(text, directory)


    def toFile(self, arg, directory):
        import os
        name = input('name: ')
        extension = input('extension: ')

        if extension.find('csv') > -1:
            arg = arg.replace(' ', ', ')


        os.system('cd ' + directory)

        if extension.find(".") == -1:
            name += "."

        fileName = name + extension

        f = open(fileName, "w+")
        arg = self.elimString(arg, "/close")
        f.write(arg)

        f.close()

        print(os.getcwd())

    def findFile(self, directory):
        import os
        toFind = input('find what? ')
        list = os.listdir(directory)
        loc = 0;
        found = 0;
        firstfound = False
        ret = ""

        while loc < len(list):
            if (list.__getitem__(loc).lower()).find(toFind.lower()) > -1 and not firstfound:
                ret = list.__getitem__(loc)
                firstfound = True
            if list.__getitem__(loc).lower().find(toFind.lower()) > -1:
                print(list.__getitem__(loc) + "\n")
                found += 1
            loc += 1

        if len(ret) > 0:
            print('found file: ' + ret + "\nmatches: " + repr(found))
        if len(ret) < 1:
            print('no matches for: ' + toFind + "\nmatches: " + repr(found))

        return ret

    def elimString(self, string, toElim):
        return string.replace(toElim, "")





    def deleteFile(self, directory):
       import os
       toFind = input('delete what? ')
       list = os.listdir(directory)
       loc = 0;
       found = 0;
       firstfound = False
       ret = ""

       while loc < len(list):
           if (list.__getitem__(loc).lower()).find(toFind.lower()) > -1 and not firstfound:
               ret = list.__getitem__(loc)
               firstfound = True
           if list.__getitem__(loc).lower().find(toFind.lower()) > -1:
               print(list.__getitem__(loc) + "\n")
               found += 1
           loc += 1

       if len(ret) > 0:
           print('found file: ' + ret + "\nmatches: " + repr(found))
       if len(ret) < 1:
           print('no matches for: ' + toFind + "\nmatches: " + repr(found))

       print(ret+"\nDelete this file? ")
       response = input('')

       if response.startswith("y"):
           os.remove(ret)
           print("Deleted successfully")
           return
       else:
           return









w = Writer()
w.beginPrompt()

