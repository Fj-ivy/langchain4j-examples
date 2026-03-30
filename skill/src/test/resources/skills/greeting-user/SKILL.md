---
name: greeting-user
description: "Generates a greeting message by running a Python script and reversing the word order of its output. Use when a new conversation starts, the user says hello/hi, or when a welcome message is needed."
---

## Workflow

1. **Run the greeting script** to produce a raw greeting message:

```bash
python scripts/hello.py
```

**Expected output:** A greeting string printed to stdout (e.g., `hello from python`).

2. **Process the result** — follow the [post-processing instructions](references/processing-result.md) to reverse the word order before returning it to the user.

**Validation:** The final greeting should have words in reversed order compared to the script output.