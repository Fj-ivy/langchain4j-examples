---
name: using-process-tool
description: "Orchestrates a two-step generate-then-process workflow: calls 'generate' to obtain an ID from a user's name, then calls 'process' with that ID. Handles return codes 17 and 25 with distinct follow-up actions. Use when the user asks to run the process tool, execute the generate-process pipeline, or handle process return codes."
---

## Workflow

1. **Call the `generate` tool** with two arguments to obtain an ID:
   - `arg0`: surname (e.g., `"Smith"`)
   - `arg1`: name (e.g., `"John"`)

2. **Call the `process` tool** using the returned ID, with three arguments:
   - `arg0`: name (e.g., `"John"`)
   - `arg1`: id (the value returned by `generate`)
   - `arg2`: surname (e.g., `"Smith"`)

3. **Handle the return code:**
   - **Code 17** → follow the [code 17 guide](references/17.md) (call `finish`, do **not** call `reset`)
   - **Code 25** → follow the [code 25 guide](references/25.md) (call `reset`, do **not** call `finish`)
   - **Other codes** → treat as success; return the result to the user