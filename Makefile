
# COLORS
GREEN		= \033[0;32m
RED 		= \033[0;31m
ORANGE		= \033[0;33m
CYAN		= \033[0;36m
RESET		= \033[0m

# PROGRAM
NAME		= Simulator
SRC_FILE	= sources.txt
OUT_FILE	= simulation.txt

all: $(NAME)

# Compile normal executable
$(NAME):
	@find * -name "*.java" > $(SRC_FILE)
	@javac @$(SRC_FILE)
	@echo "[$(ORANGE)$(NAME)$(RESET)] Creation *.class files : $(GREEN)OK$(RESET)]"
	@echo "[$(GREEN)success$(RESET)]: $(NAME) is ready]"

clean:
	@rm $$(find . -name "*.class")
	@rm $(SRC_FILE)
	@echo "[$(ORANGE)$(NAME)$(RESET)] clean *.class files : $(GREEN)OK$(RESET)"

fclean:	clean
	@rm $(OUT_FILE)
	@echo "[$(ORANGE)$(NAME)$(RESET)] fclean: $(GREEN)OK$(RESET)"
	@echo "[$(GREEN)success$(RESET)]: $(NAME) has been cleaned up"

re: fclean all

run: $(NAME)
	@java src.Simulator scenario.txt

.PHONY: all clean fclean re run
